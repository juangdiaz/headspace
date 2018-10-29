package com.juangdiaz.headspace.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.juangdiaz.headspace.R;
import com.juangdiaz.headspace.adapters.ItemsAdapter;
import com.juangdiaz.headspace.models.WalmartResponse;
import com.juangdiaz.headspace.ui.presenters.MainPresenter;
import com.juangdiaz.headspace.ui.views.MainViewInterface;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    private String TAG = "MainActivity";

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupMVP();
        setupViews();
        getMovieList();
    }


    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(){
    }

    private void getMovieList() {

        mainPresenter.getItems();

    }


    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void displayItems(WalmartResponse walmartResponse) {

        if (walmartResponse != null) {
            Log.d(TAG, walmartResponse.getItems().get(1).getName());

            ViewPager viewPager = findViewById(R.id.viewpager);
            viewPager.setAdapter(new ItemsAdapter(this, walmartResponse.getItems()));
        } else {
            Log.d(TAG, "Walmart Items response null");
        }
    }

    @Override
    public void displayError(String e) {

        showToast(e);
    }
}
