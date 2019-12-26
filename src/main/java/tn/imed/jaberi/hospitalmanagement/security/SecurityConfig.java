package tn.imed.jaberi.hospitalmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    private final String[] __PUBLIC_ENDPOINTS__ = {
            "/api/v1/auth/**",
    };
    
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    
    @Bean
    AuthFilter authFilter() {
    	return new AuthFilter();
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors().and().csrf().disable() // enable just for session / cookies & basic authentication
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // STATELESS ==> we don't need session and basic auth  < JWT >
				.and()
			.authorizeRequests()
				.antMatchers(__PUBLIC_ENDPOINTS__).permitAll() // all public entry point .. 
				.anyRequest().authenticated() // protected entry point .. 
				.and()
			.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
			// .httpBasic(); // basic auth <login & password correct ==> pass> ..
				
	}
	
}
