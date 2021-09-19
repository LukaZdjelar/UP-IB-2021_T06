package com.ftn.domzdravlja.model;

public class KorisnikToken {

    private String access_token;

    public KorisnikToken() {
        this.access_token = null;
    }

    public KorisnikToken(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }


}
