package com.retrofit.android.retrofitdemo;

import com.retrofit.android.retrofitdemo.OAuth.AccessToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Luis on 20/02/2017.
 */

public interface LoginService {
    @FormUrlEncoded
    @POST("/token")
    Call<AccessToken> getAccessToken(
            @Field("code") String code,
            @Field("grant_type") String grantType);
}

