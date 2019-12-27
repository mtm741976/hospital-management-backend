package tn.imed.jaberi.hospitalmanagement.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.imed.jaberi.hospitalmanagement.error.NotFoundException;


@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Bean 
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// return new org.springframework.security.core.userdetails.User("Imed",passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES); /* collection fer8a */
		User user = userRepository.findByEmail(username);
		if (user == null) { 
			throw new NotFoundException("User Not Found");
		} 
		
		return user;
	}

	
	public User save(User user) {
		user.setPassword(passwordEncoder().encode(user.getPassword())); 
		return userRepository.save(user);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
}
