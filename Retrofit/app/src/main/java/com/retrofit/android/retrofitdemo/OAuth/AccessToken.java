package com.retrofit.android.retrofitdemo.OAuth;

/**
 * Created by Luis on 20/02/2017.
 */

public class AccessToken {

    private String token;
    private String token_type;
    private Integer expires_in;
    private String refreshToken;
    private String scope;
    private String client_id;
    private String client_secret;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private String timestamp;

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String access_token) {
        this.token = access_token;
    }

    public String getTokenType() {
        // OAuth requires uppercase Authorization HTTP header value for token type
        if(!Character.isUpperCase(token_type.charAt(0))) {
            token_type = Character.toString(token_type.charAt(0)).toUpperCase() + token_type.substring(1);
        }

        if(token_type == null)
            token_type = "Bearer";

        return token_type;
    }

    public void setTokenType(String token_type) {
        this.token_type = token_type;
    }

    public int getExpiry() {
        return expires_in;
    }

    public void setExpiry(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refresh_token) {
        this.refreshToken = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getClientID() {
        return client_id;
    }

    public void setClientID(String client_id) {
        this.client_id = client_id;
    }

    public String getClientSecret() {
        return client_secret;
    }

    public void setClientSecret(String client_secret) {
        this.client_secret = client_secret;
    }
}