/**
 * This is not part of the project .. 
 * It's just "hello world 👋🏻" for heroku ..
 *
 */


package tn.imed.jaberi.hospitalmanagement.hello_heroku;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Heroku {
	
	
	@GetMapping(value = { "/api", "/api/"})
	public ResponseEntity<Map> HelloWord(){
		Map res = new HashMap<String, String>();
		res.put("msg", "Hello, Welcome to our REST API 👋🏻  .. ");
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
