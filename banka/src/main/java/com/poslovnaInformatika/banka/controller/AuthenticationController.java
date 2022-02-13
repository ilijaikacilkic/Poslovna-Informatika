package com.poslovnaInformatika.banka.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovnaInformatika.banka.entity.Korisnik;
import com.poslovnaInformatika.banka.security.AuthenticationRequest;
import com.poslovnaInformatika.banka.security.AuthenticationResponse;
import com.poslovnaInformatika.banka.security.JWTUtils;
import com.poslovnaInformatika.banka.service.KorisnikService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationManager authenticationManager;

	private final KorisnikService korisnikService;
	
	private final JWTUtils jwtUtils;

	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialsException, InvalidKeySpecException, NoSuchAlgorithmException {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		
		final Korisnik korisnik = korisnikService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtils.generateToken(korisnik);
		
		return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
	}
}
