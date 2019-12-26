package tn.imed.jaberi.hospitalmanagement.patient;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document(collection = "patients")
public class Patient {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String malady;
	private int age;
	private Date created_at;
	
	public Patient() {
		this.created_at = new Date(System.currentTimeMillis());
	}
	
	private Patient(String id, String firstName, String lastName, String malady, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.malady = malady;
		this.age = age;
		this.created_at = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMalady() {
		return malady;
	}

	public void setMalady(String malady) {
		this.malady = malady;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

}
