package com.poslovnaInformatika.banka.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.poslovnaInformatika.banka.entity.Korisnik;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {
	
private int tokenExpiration;
	
	private final JWTKeyProvider keyProvider;
	
	@Autowired
	public JWTUtils(@Value("${jwt.tokenExpiration}") int tokenExpiration, JWTKeyProvider keyProvider) {
		this.tokenExpiration = tokenExpiration;
		this.keyProvider = keyProvider;
		
	}

    public String generateToken(Korisnik korisnik) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Map<String, Object> claims = new HashMap<>();
        List<String> authorities = korisnik.getAuthorities().stream()
        		.map(authority -> authority.getAuthority())
        		.collect(Collectors.toList());
        
        claims.put("authorities", authorities);
        claims.put("name", korisnik.getKlijent().getIme() + " " + korisnik.getKlijent().getPrezime());
        return createToken(claims, korisnik.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) throws InvalidKeySpecException, NoSuchAlgorithmException {
    	
        return Jwts.builder().setClaims(claims)
        		.setSubject(subject)
        		.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * tokenExpiration))
                .addClaims(claims)
                .signWith(SignatureAlgorithm.RS256, keyProvider.getPrivateKey()).compact();
    }
}
