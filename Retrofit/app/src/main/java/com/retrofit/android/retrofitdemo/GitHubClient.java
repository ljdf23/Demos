package com.retrofit.android.retrofitdemo;

import com.retrofit.android.retrofitdemo.models.Response.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Luis on 20/02/2017.
 */

public interface GitHubClient {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}