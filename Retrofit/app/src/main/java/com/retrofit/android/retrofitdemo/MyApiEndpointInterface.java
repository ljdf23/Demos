package com.retrofit.android.retrofitdemo;
import com.retrofit.android.retrofitdemo.models.Request.Negocio;
import com.retrofit.android.retrofitdemo.models.Response.NegocioResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Luis on 29/01/2017.
 */

public interface MyApiEndpointInterface {

    @Headers("Content-Type: application/json")
    @POST("sync/negocio")
    Call<NegocioResponse> PostNegocio(@Body Negocio negocio);
}