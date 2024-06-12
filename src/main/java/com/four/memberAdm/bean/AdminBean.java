package com.four.memberAdm.bean;

public class AdminBean implements java.io.Serializable {
	
	private int admNo;
	private String admName;
	private String admEmail;
	private String admPassword;
	private String phone;
	private int status;
	
	// getters and setters
	public int getAdmNo() {
		return admNo;
	}
	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmEmail() {
		return admEmail;
	}
	public void setAdmEmail(String admEmail) {
		this.admEmail = admEmail;
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	// constructor
	public AdminBean(String admName, String admEmail, String admPassword, String phone, int status) {
		super();
		this.admName = admName;
		this.admEmail = admEmail;
		this.admPassword = admPassword;
		this.phone = phone;
		this.status = status;
	}
	public AdminBean(int admNo, String admName, String admEmail, String admPassword, String phone, int status) {
		super();
		this.admNo = admNo;
		this.admName = admName;
		this.admEmail = admEmail;
		this.admPassword = admPassword;
		this.phone = phone;
		this.status = status;
	}
	public AdminBean() {
		super();
	}
	
	

}
