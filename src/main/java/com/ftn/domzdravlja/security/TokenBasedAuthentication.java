package com.ftn.domzdravlja.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import com.ftn.domzdravlja.model.Korisnik;

public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private String token;
    private final Korisnik korisnik;

    public TokenBasedAuthentication( Korisnik korisnik ) {
        super( korisnik.getAuthorities() );
        this.korisnik = korisnik;
    }

    public String getToken() {
        return token;
    }

    public void setToken( String token ) {
        this.token = token;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Korisnik getPrincipal() {
        return korisnik;
    }

}

