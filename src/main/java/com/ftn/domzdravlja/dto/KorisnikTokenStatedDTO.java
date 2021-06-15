package com.ftn.domzdravlja.dto;

public class KorisnikTokenStatedDTO {
	
	private String access_token;

    public KorisnikTokenStatedDTO() {
        this.access_token = null;
    }

    public KorisnikTokenStatedDTO(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

}
