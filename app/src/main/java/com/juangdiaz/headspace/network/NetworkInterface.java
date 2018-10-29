package com.juangdiaz.headspace.network;

import com.juangdiaz.headspace.models.WalmartResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {


    @GET("items?format=json")
    Observable<WalmartResponse> getWalmartItems(@Query("apiKey") String api_key);
}
