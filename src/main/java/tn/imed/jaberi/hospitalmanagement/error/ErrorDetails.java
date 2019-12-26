package tn.imed.jaberi.hospitalmanagement.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {
	
	private String message;
	private String uri;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss" )
	private Date timesamp;
	
	public ErrorDetails () {
		this.timesamp = new Date();
	}
	
	public ErrorDetails (String message, String uri) {
		this();
		this.message = message;
		this.uri = uri;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public Date getTimesamp() {
		return timesamp;
	}
	
	public void setTimesamp(Date timesamp) {
		this.timesamp = timesamp;
	}

}
