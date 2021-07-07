package com.ftn.domzdravlja.dto;

public class KorisnikTokenStatedDTO {
	
	private String access_token;

	private String refreshToken;

    private String role;

    public KorisnikTokenStatedDTO() {
        this.access_token = null;
    }

    public KorisnikTokenStatedDTO(String access_token, String refreshToken, String role) {
        this.access_token = access_token;
        this.refreshToken = refreshToken;
        this.role = role;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}
