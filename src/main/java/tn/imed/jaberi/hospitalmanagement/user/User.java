package tn.imed.jaberi.hospitalmanagement.user;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document(collection = "users")
public class User {
	
	@Id
	private String Id;
    private String email;
    private String name;
    private String password;
    private Date created_at;
    
    
	public User() {}
    
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.created_at = new Date();
    }

}
