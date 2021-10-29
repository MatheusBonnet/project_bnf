package com.bnf.aep.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.bnf.aep.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	private static final long expirationTime = 1800000;
	
	private String key = "String aleatoria";
	
	public String generateToken(User token) {
		return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject("Teste jwt api").setExpiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(SignatureAlgorithm.HS256, key)
				.compact();
	}

	public Claims decodeToken(String token) {
		return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
	}

}
