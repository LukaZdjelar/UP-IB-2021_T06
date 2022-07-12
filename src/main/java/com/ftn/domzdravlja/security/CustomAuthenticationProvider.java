package com.ftn.domzdravlja.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.service.KorisnikService;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider  {
	@Autowired
	 private KorisnikService userService;
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	@Autowired
	public CustomAuthenticationProvider(KorisnikService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String username = authentication.getName();
	     String password = authentication.getCredentials().toString();
	     
	     Korisnik korisnik = userService.findKorisnik(username);
	     
	     if (korisnik == null) {
	    	 throw new RuntimeException("Invalid username.");
	     }
	     if(password == null) {
	    	 throw new RuntimeException("Invalid password.");
	     }
	     boolean matches = passwordEncoder.matches(password, korisnik.getPassword());
	     if (!matches) {
	        throw new RuntimeException("Invalid username or password.");
	     }
	     return new UsernamePasswordAuthenticationToken(korisnik, korisnik.getPassword(), korisnik.getAuthorities());
	   
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	} 
}

