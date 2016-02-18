package com.cailine.neighbor.model;

/**
 * Created by liying on 2016/2/18.
 */
public class TokenInfo {
    private String token;
    private String expires;

    public TokenInfo(String token, String expires) {
        this.token = token;
        this.expires = expires;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }
}
