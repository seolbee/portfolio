package VO;

import java.util.Date;

public class UserVO {
	private int userNO;
	private String id;
	private String pass;
	private String name;
	private Date birthDate;
	
	public UserVO(int userNO, String id, String pass, String name, Date birthDate) {
		this.userNO = userNO;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getUserNO() {
		return userNO;
	}
	
	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
