package com.ftn.domzdravlja.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.repository.KorisnikRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {


    private final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired 
    private KorisnikRepository userRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    @Autowired 
    private AuthenticationManager authenticationManager;


    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        Korisnik korisnik = userRepository.findByEmail(email);
        if (korisnik == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        } else {
            return korisnik;
        }
    }

    public void changePassword(String oldPassword, String newPassword) {

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String email = currentUser.getName();

        if (authenticationManager != null) {
            LOGGER.debug("Re-authenticating user '"+ email + "' for password change request.");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, oldPassword));
        } else {
            LOGGER.debug("No authentication manager set. can't change Password!");

            return;
        }

        LOGGER.debug("Changing password for user '"+ email + "'");

        Korisnik korisnik = (Korisnik) loadUserByEmail(email);

        korisnik.setLozinka(passwordEncoder.encode(newPassword));
        userRepository.save(korisnik);

    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}