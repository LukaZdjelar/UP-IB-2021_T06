package com.ftn.domzdravlja.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.domzdravlja.controller.LoginController.PasswordChanger;
import com.ftn.domzdravlja.dto.KorisnikTokenStatedDTO;
import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.model.RefreshToken;
import com.ftn.domzdravlja.repository.RefreshTokenRepository;
import com.ftn.domzdravlja.security.LoginAuthenticationRequest;
import com.ftn.domzdravlja.security.TokenHelper;
import com.ftn.domzdravlja.service.CustomUserDetailService;
@RestController
@RequestMapping(value = "domZdravlja/aou")
public class LoginController{

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailsService;


    @PostMapping(value = "/login")
    @PreAuthorize("hasAnyRole('ADMIN','PATIENT', 'DOCTOR', 'NURSE', 'STAFF')")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody LoginAuthenticationRequest authenticationRequest,
            HttpServletResponse response
    ) throws AuthenticationException, IOException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Korisnik korisnik = (Korisnik)authentication.getPrincipal();
        String jws = tokenHelper.generateToken( korisnik);
        String refreshToken = "" ;
        return ResponseEntity.ok(new KorisnikTokenStatedDTO(jws, refreshToken, Korisnik.getUserRoles()));
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        Korisnik ulogovan = (Korisnik) authentication.getPrincipal();

        userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{refreshToken}")
    public ResponseEntity<KorisnikTokenStatedDTO> generateJWTFromRefreshToken(@PathVariable String refreshToken, @AuthenticationPrincipal Korisnik user){
        RefreshToken refToken = refreshTokenRepository.findByToken(refreshToken);
        if(!(refToken.getExpiresIn() <= Instant.now())){
            String jws = tokenHelper.generateToken(user);
            return ResponseEntity.ok(new KorisnikTokenStatedDTO(jws, refreshToken,Korisnik.getUserRoles()));
        }
    }

    static class PasswordChanger {
        public String oldPassword;
        public String newPassword;
    }
}