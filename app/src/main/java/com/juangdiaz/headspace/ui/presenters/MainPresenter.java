package com.juangdiaz.headspace.ui.presenters;

import android.util.Log;

import com.juangdiaz.headspace.models.WalmartResponse;
import com.juangdiaz.headspace.network.NetworkClient;
import com.juangdiaz.headspace.network.NetworkInterface;
import com.juangdiaz.headspace.ui.views.MainViewInterface;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainPresenterInterface {

    private String TAG = "MainPresenter";

    MainViewInterface mvi;

    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getItems() {

        getObservable().subscribeWith(getObserver());
    }

    public Observable<WalmartResponse> getObservable() {
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getWalmartItems("xfb7ays7g665raye3s2rkxqe")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<WalmartResponse> getObserver() {
        return new DisposableObserver<WalmartResponse>() {

            @Override
            public void onNext(@NonNull WalmartResponse walmartResponse) {
                Log.d(TAG, "OnNext" + walmartResponse.getTotalPages());
                mvi.displayItems(walmartResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error" + e);
                e.printStackTrace();
                mvi.displayError("Error fetching Walmart Items");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");

                mvi.hideProgressBar();
            }
        };
    }
}
