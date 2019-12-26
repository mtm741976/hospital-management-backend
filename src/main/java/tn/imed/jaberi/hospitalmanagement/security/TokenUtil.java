package tn.imed.jaberi.hospitalmanagement.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtil {

	private final String __CLAIMS_SUB__ = "sub";
	private final String __CLAIMS_CREATED__ = "created";
	
	@Value("${auth.expiration}") // get value from application.yml
	private long __TOKEN_VALIDITY__ = 604800L;
	
    @Value("${auth.secret}")
    private String __TOKEN_SECRET__;
    
	public String generateToken(UserDetails userDetails) {
		
		// clains +  expration = sign --(string)--> compact ..
		
		Map<String, Object> claims = new HashMap<String, Object>(); 
		claims.put(__CLAIMS_SUB__, userDetails.getUsername());
		claims.put(__CLAIMS_CREATED__, new Date());
		
		return Jwts.builder()
					.setClaims(claims)
					.setExpiration(generateExpirationDate())
					.signWith(SignatureAlgorithm.HS512, __TOKEN_SECRET__)
					.compact();
	}
	
	public String getUserNameFromToken(String token) {
		try {
			
			Claims claims = getClaims(token);
			
			return claims.getSubject();
			
		} catch (Exception ex) {
			return null;
		}
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
    private boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date()); // ken expiration b3ed date lyoum ==> false .. 
    }
	
    private Claims getClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(__TOKEN_SECRET__)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception ex) {
            claims = null;
        }

        return claims;
    }
    
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + __TOKEN_VALIDITY__ * 1000);
    }
}
