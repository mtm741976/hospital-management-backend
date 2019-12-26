package tn.imed.jaberi.hospitalmanagement.room;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Document(collection = "rooms")
public class Room {

  @Id
  private String id;
  private String title;
  private Date created_at;
	
  public Room() {
	  this.created_at = new Date();
  }
  
  public Room(String title) {
	  this.title = title;
  }

  public String getId() {
	  return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }

}