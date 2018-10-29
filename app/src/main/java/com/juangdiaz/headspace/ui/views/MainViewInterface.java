package com.juangdiaz.headspace.ui.views;

import com.juangdiaz.headspace.models.WalmartResponse;

public interface MainViewInterface {

    void showProgressBar();
    void hideProgressBar();
    void showToast(String s);
    void displayItems(WalmartResponse walmartResponse);
    void displayError(String s);
}
