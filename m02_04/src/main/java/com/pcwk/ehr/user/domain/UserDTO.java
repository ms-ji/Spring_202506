package com.pcwk.ehr.user.domain;

public class UserDTO {
	//세로 편집 : alt+shift+a
	//대/소문자 변환 : ctrl+shift+x/y
		
	//UserDTO
	//---------------------------
	//전역변수
	//디폴트 생성자
	//인자 있는 생성자
	//get/setters
	//toString()
		
	private String userId      ;//사용자Id
	private String name        ;//사용자 이름
	private String password    ;//비밀번호
	private String regDt       ;//등록일
	
	public UserDTO() {}
	
	
	public UserDTO(String userId, String name, String password, String regDt) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.regDt = regDt;
	}


	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRegDt() {
		return regDt;
	}
	
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", password=" + password + ", regDt=" + regDt + "]";
	}
		
		
}
