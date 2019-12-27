package tn.imed.jaberi.hospitalmanagement.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.imed.jaberi.hospitalmanagement.security.TokenUtil;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager; 
    
    @PostMapping({"", "/", "/login", "/login/"})
	public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
		);
		
		SecurityContextHolder.getContext().setAuthentication(authentication); // push authnetcation fi conatiner .. 
		
        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername()); // 5dhina username o 3amnelo load 
        String token = tokenUtil.generateToken(userDetails); // generate token .. 
        
        JwtResponse response = new JwtResponse(token);
        
        return response;
	}

    @PostMapping({ "/register", "/register/" })
	public ResponseEntity<User> register(@Valid @RequestBody User user) {
        User result = userService.save(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
    

}
