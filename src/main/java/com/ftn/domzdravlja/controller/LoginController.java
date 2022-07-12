package com.ftn.domzdravlja.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.domzdravlja.dto.KorisnikTokenStatedDTO;
import com.ftn.domzdravlja.dto.RefreshTokenRequestDto;
import com.ftn.domzdravlja.exception.TokenRefreshException;
import com.ftn.domzdravlja.model.Korisnik;
import com.ftn.domzdravlja.model.RefreshToken;
import com.ftn.domzdravlja.security.LoginAuthenticationRequest;
import com.ftn.domzdravlja.security.TokenHelper;
import com.ftn.domzdravlja.service.CustomUserDetailService;
import com.ftn.domzdravlja.service.KorisnikService;
import com.ftn.domzdravlja.service.RefreshTokenService;

@RestController
@RequestMapping(value = "domZdravlja/auth")
@CrossOrigin(origins = "https://localhost:3000")
public class LoginController {

	TokenHelper tokenHelper;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailService userDetailsService;
	@Autowired
	private RefreshTokenService refreshTokenService;
	@Autowired
	private KorisnikService korisnikService;

	public LoginController(TokenHelper tokenHelper, AuthenticationManager authenticationManager,
			CustomUserDetailService userDetailsService, RefreshTokenService refreshTokenService,
			KorisnikService korisnikService) {
		this.tokenHelper = tokenHelper;
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.refreshTokenService = refreshTokenService;
		this.korisnikService = korisnikService;
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginAuthenticationRequest authenticationRequest,
			HttpServletResponse response) throws AuthenticationException, IOException {

		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
						authenticationRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Korisnik korisnik = (Korisnik) authentication.getPrincipal();
		String jwt = tokenHelper.generateToken(korisnik);
		String refreshToken = refreshTokenService.createRefreshToken(korisnik.getId()).getToken();

		return ResponseEntity.ok(new KorisnikTokenStatedDTO(jwt, refreshToken));
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Korisnik ulogovan = (Korisnik) authentication.getPrincipal();

		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("refreshToken")
	public ResponseEntity<KorisnikTokenStatedDTO> generateJWTFromRefreshToken(
			@RequestBody RefreshTokenRequestDto tokenRequestDto) {
		RefreshToken refToken = refreshTokenService.findByToken(tokenRequestDto.getRefreshToken());

		if (refToken != null) {
			try {
				refToken = refreshTokenService.verifyExpiration(refToken);
				Korisnik korisnik = korisnikService.findById(refToken.getUserId());
				String jwt = tokenHelper.generateToken(korisnik);
				return ResponseEntity.ok(new KorisnikTokenStatedDTO(jwt, refToken.getToken()));

			} catch (TokenRefreshException exception) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}

		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
}