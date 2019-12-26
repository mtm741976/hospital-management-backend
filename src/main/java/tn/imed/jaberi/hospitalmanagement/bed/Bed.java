package tn.imed.jaberi.hospitalmanagement.bed;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document(collection = "beds")
public class Bed {

	@Id
	private String id;
  	private String imgUrl;
  	private String desc;
	private Date created_at;
	
	public Bed() {}
	
	private Bed(String id, String imgUrl, String desc) {
		this.id = id;
		this.imgUrl = imgUrl;
		this.desc = desc;
		this.created_at = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

}