package utils;

import java.io.Serializable;

public class ExamsUtil implements Serializable{
	private static final long serialVersionUID = 1L;
	private static String username;
	private static String examid;
	
	public static String getUsername() {
		return username;
	}
	public static String geteid() {
		return examid;
	}

	public void setUsername(String username) {
		ExamsUtil.username = username;
	}
	public void seteid(String examid) {
		ExamsUtil.examid = examid;
	}
}