package com.juangdiaz.headspace.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.juangdiaz.headspace.R;
import com.juangdiaz.headspace.adapters.ItemsAdapter;
import com.juangdiaz.headspace.models.WalmartResponse;
import com.juangdiaz.headspace.ui.presenters.MainPresenter;
import com.juangdiaz.headspace.ui.views.MainViewInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    private String TAG = "MainActivity";

    @BindView(R.id.progressBar) ProgressBar progressBar;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Initialize the list
        setupMVP();
        getItemsList();
    }


    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void getItemsList() {

        //fetch data from the presenter
        mainPresenter.getItems();
    }

    @Override
    public void showProgressBar() {}

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayItems(WalmartResponse walmartResponse) {

        if (walmartResponse != null) {

            Log.d(TAG, walmartResponse.getItems().get(1).getName());

            ViewPager viewPager = findViewById(R.id.viewpager);
            viewPager.setAdapter(new ItemsAdapter(this, walmartResponse.getItems()));
        } else {

            Log.d(TAG, "Walmart Items response null");
            showToast("There are no items in the list");
        }
    }

    @Override
    public void displayError(String e) {

        showToast(e);
    }
}
