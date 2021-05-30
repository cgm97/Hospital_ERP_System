package com.kyumin.erpsystem.utility;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.kyumin.erpsystem.member.Login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	private String SECRET_KEY = "kyumin";
	
	public String createToken(Login login, String subject) {
        // 토큰을 서명하기 위해 사용해야할 알고리즘 선택
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
 
        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
        return Jwts.builder()
        		.claim("ID",login.getId())
        		.claim("PW",login.getPw())
				.setSubject(subject)
				.signWith(signatureAlgorithm, signingKey)
				.setExpiration(new Date(System.currentTimeMillis()+ 1000 *60 *60 *10))
				.compact();
	}
	
	public String getSubject(String token) {
		 Claims claims = Jwts.parser()
		 .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
		 .parseClaimsJws(token)
		 .getBody();
		  return claims.getSubject();
	}

	public String getId(String token) {
		Claims claims = Jwts.parser()
						.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
						.parseClaimsJws(token)
						.getBody();
		return claims.get("ID")+"";
	}

	public String getPw(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.parseClaimsJws(token)
				.getBody();
		return claims.get("PW")+"";
	}
}
