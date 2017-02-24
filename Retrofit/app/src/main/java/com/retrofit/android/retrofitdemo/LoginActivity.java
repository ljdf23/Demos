package com.retrofit.android.retrofitdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.retrofit.android.retrofitdemo.OAuth.AccessToken;
import com.retrofit.android.retrofitdemo.OAuth.ServiceGenerator;
import com.retrofit.android.retrofitdemo.models.Response.GitHubRepo;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();

        // the intent filter defined in AndroidManifest will handle the return from ACTION_VIEW intent
        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(redirectUri)) {
            // use the parameter your API exposes for the code (mostly it's "code")
            String code = uri.getQueryParameter("code");
            if (code != null) {
                // get access token
                LoginService loginService =
                        ServiceGenerator.createService(LoginService.class, clientId, clientSecret);
                Call<AccessToken> call = loginService.getAccessToken(code, "authorization_code");
                try {
                    AccessToken accessToken = call.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (uri.getQueryParameter("error") != null) {
                // show an error message here
            }
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    private final String clientId = "CwAaJNuaX2MMHhNnHofUDykt8PkfYJ8QLq4QXvV6";
    private final String clientSecret = "your-client-secret";
    private final String redirectUri = "your://redirecturi";
    String API_BASE_URL = "https://api.github.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button loginButton = (Button) findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //region old connection
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

                Retrofit.Builder builder =
                        new Retrofit.Builder()
                                .baseUrl(API_BASE_URL)
                                .addConverterFactory(
                                        GsonConverterFactory.create()
                                );

                Retrofit retrofit =
                        builder
                                .client(
                                        httpClient.build()
                                )
                                .build();

                GitHubClient client =  retrofit.create(GitHubClient.class);

                // Fetch a list of the Github repositories.
                Call<List<GitHubRepo>> call =
                        client.reposForUser("fs-opensource");

                // Execute the call asynchronously. Get a positive or negative callback.
                call.enqueue(new Callback<List<GitHubRepo>>() {
                    @Override
                    public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                        // The network call was a success and we got a response
                        // TODO: use the repository list and display it
                        Log.i(String.valueOf(call.isExecuted()), response.message());
                    }

                    @Override
                    public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                        // the network call was a failure
                        // TODO: handle error
                        Log.i(String.valueOf(call.isExecuted()), t.getMessage());
                    }
                });

                //endregion

                //region url view
                 /*   Intent intent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(ServiceGenerator.API_BASE_URL + "/sso-login" + "?username=mimoni.com&password=j8Yc$t3V&client_id=" + clientId + "&grant_type=password"));// "&redirect_uri=" + redirectUri));
                    startActivity(intent);
                    */
                //endregion

                //region really implementation
               /* LoginService loginService =
                        ServiceGenerator.createService(LoginService.class, clientId, clientSecret);
                Call<AccessToken> call = loginService.getAccessToken(code, "authorization_code");
                try {
                    AccessToken accessToken = call.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                //endregion


            }

        });
    }
}