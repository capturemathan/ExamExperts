package utils;

import java.io.Serializable;

public class CollegesUtil implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String univid;

	
	public String getUsername() {
		return username;
	}
	
	public String getuid() {
		return univid;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setuid(String univid) {
		this.univid = univid;
	}
	
	
}
