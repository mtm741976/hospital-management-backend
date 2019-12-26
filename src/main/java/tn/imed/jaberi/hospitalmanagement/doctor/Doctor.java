package tn.imed.jaberi.hospitalmanagement.doctor;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document(collection = "doctors")
public class Doctor {

	@Id
	private String id;
	private String fullName;
	private String imgUrl;
	private String specialty;
	private String desc;
	private int age;
	private Date created_at;
	
	public Doctor() {
		this.created_at = new Date();
	}
	
	private Doctor(String id, String fullName, String imgUrl, String specialty, String desc, int age) {
		this.id = id;
		this.fullName = fullName;
		this.imgUrl = imgUrl;
		this.specialty = specialty;
		this.desc = desc;
		this.age = age;
		this.created_at = new Date();
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
