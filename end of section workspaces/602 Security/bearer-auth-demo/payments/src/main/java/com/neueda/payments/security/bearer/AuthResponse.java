package com.neueda.payments.security.bearer;

public class AuthResponse {


    private final String jwt;
    private final String refreshJwt;

    public AuthResponse(String jwt, String refreshJwt) {
        this.jwt = jwt;
        this.refreshJwt = refreshJwt;
    }

    public String getJwt() {
        return jwt;
    }

    public String getRefreshJwt() {
        return refreshJwt;
    }
}
