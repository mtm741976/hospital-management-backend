package tn.imed.jaberi.hospitalmanagement.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import tn.imed.jaberi.hospitalmanagement.user.UserService;



public class AuthFilter extends OncePerRequestFilter {
	
	@Value("${auth.header}")
	private String __TOKEN_HEADER__;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private UserService userService;
    
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// get token form header 
		// make sure it's valid 
		
		final String header = request.getHeader(__TOKEN_HEADER__); // extract the hedders auth .. 
		final SecurityContext securityContext = SecurityContextHolder.getContext(); // extract container .. 
		
		if (header != null && securityContext.getAuthentication() == null) {
			
			String token = header.substring("Bearer ".length());
			String username = tokenUtil.getUserNameFromToken(token);
			
			if(username != null ) {
				UserDetails userDetails = userService.loadUserByUsername(username);
				if(tokenUtil.isTokenValid(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // setting to auth 
                    SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}

		filterChain.doFilter(request, response);
	}

}