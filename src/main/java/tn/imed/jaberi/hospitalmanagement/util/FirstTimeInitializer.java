package tn.imed.jaberi.hospitalmanagement.security;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tn.imed.jaberi.hospitalmanagement.user.User;
import tn.imed.jaberi.hospitalmanagement.user.UserService;



@Component
public class FirstTimeInitializer implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);
	
	@Autowired
	private UserService userService;
	
	
	@Override 
	public void run(String... args) throws Exception { // awel mal container yruni
		// check if we have users .. 
		// if no user exist, create one ..
		if(userService.findAll().isEmpty()) {
			logger.info("No Users accounts found. Creating some users !");
			
			User user = new User("imed_jebari@hotmail.fr", "password", "Imed");
			userService.save(user);
		}else {
			System.out.println("Imed Jaberi !");
		}
	}

}
