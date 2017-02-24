package com.retrofit.android.retrofitdemo;
import com.retrofit.android.retrofitdemo.db.PhoneAllLines;
import com.retrofit.android.retrofitdemo.models.Request.Negocio;
import com.retrofit.android.retrofitdemo.models.Response.NegocioResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Luis on 29/01/2017.
 */

public interface MyApiEndpointInterface {

    @Headers("Content-Type: application/json")
    @POST("sync/negocio")
    Call<NegocioResponse> PostNegocio(@Body Negocio negocio);

    @Headers("Content-Type: application/json")
    @GET("client/{id}/lines/")
    Call<PhoneAllLines> GetAllLines(@Path("id") String user);

    @Headers("Content-Type: application/json")
    @GET("client/{id}/lines/")
    Call<PhoneAllLines> GetNextPayments(@Path("id") String user);

    @Headers("Content-Type: application/json")
    @GET("client/{id}/lines/")
    Call<PhoneAllLines> GetPaymentReferences(@Path("id") String user);

    @Headers("Content-Type: application/json")
    @GET("client/{id}/lines/")
    Call<PhoneAllLines> GetApoyaTInfo(@Path("id") String user);

    @Headers("Content-Type: application/json")
    @GET("client/{id}/lines/")
    Call<PhoneAllLines> GetCatalogs(@Path("id") String user);
}
