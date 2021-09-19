package com.ftn.domzdravlja.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.service.CustomUserDetailService;
import com.ftn.domzdravlja.service.KorisnikService;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    private TokenHelper tokenHelper;

    private CustomUserDetailService korisnikService;

    public TokenAuthenticationFilter(TokenHelper tokenHelper, CustomUserDetailService korisnikService) {
        this.tokenHelper = tokenHelper;
        this.korisnikService = korisnikService;
    }


    @Override
    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        String email;
        String authToken = tokenHelper.getToken(request);

        if (authToken != null) {
            email = tokenHelper.getEmailFromToken(authToken);
            if (email != null) {
                Korisnik userDetails = (Korisnik) korisnikService.loadUserByEmail(email);
                if (tokenHelper.validateToken(authToken, userDetails)) {
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}

