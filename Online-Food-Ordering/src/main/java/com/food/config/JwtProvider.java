package com.food.config;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Service
public class JwtProvider {
	
	@Value("${jwt.secret}")
    private String jwtSecret;

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }
	
	public String generationToken(Authentication auth) {
		Collection<? extends GrantedAuthority>authorities=auth.getAuthorities();
		String role = populateAuthorities(authorities);
		
		String Jwt=Jwts.builder().setIssuedAt(new Date())
				.setExpiration((new Date(new Date().getTime()+65000000)))
				.claim("email",auth.getName())
				.claim("authorities",role)
				.signWith(key)
				.compact();
		
		return Jwt;
	}
	
	public String getEmailFromJwtToken(String jwt) {
		jwt = jwt.substring(7);
		Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
		
		String email = String.valueOf(claims.get("email"));
		return email;
	}

	private String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
		
		Set<String> auths=new HashSet<>();
		
		for(GrantedAuthority authority:authorities) {
			auths.add(authority.getAuthority());
		}
		
		return String.join(",", auths);
	}
}
