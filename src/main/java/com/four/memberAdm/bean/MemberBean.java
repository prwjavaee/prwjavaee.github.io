package com.four.memberAdm.bean;

import jakarta.servlet.http.Part;

public class MemberBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int memNo;
	private String memName;
	private String memEmail;
	private String memPassword;
	private int gender;
	private String birth;
	private int age;
	private String phone;
	private String regDate;
	private int status;
	private String nickName;
//	private String memPic;
//	private Part memPic;
	private byte[] memPic;
	
	// getters and setters
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public byte[] getMemPic() {
		return memPic;
	}
	public void setMemPic(byte[] memPic) {
		this.memPic = memPic;
	}
	
	// constructor
	
	public MemberBean(String memName, String memEmail, String memPassword, int gender, String birth, int age,
			String phone, String regDate, int status, String nickName, byte[] memPic) {
		super();
		this.memName = memName;
		this.memEmail = memEmail;
		this.memPassword = memPassword;
		this.gender = gender;
		this.birth = birth;
		this.age = age;
		this.phone = phone;
		this.regDate = regDate;
		this.status = status;
		this.nickName = nickName;
		this.memPic = memPic;
	}
	public MemberBean(int memNo, String memName, String memEmail, String memPassword, int gender, String birth,
			String phone, int status, String nickName, byte[] memPic) {
		super();  // 更新用
		this.memNo = memNo;
		this.memName = memName;
		this.memEmail = memEmail;
		this.memPassword = memPassword;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.status = status;
		this.nickName = nickName;
		this.memPic = memPic;
	}
	public MemberBean(String memName, String memEmail, String memPassword, int gender, String birth, String phone,
			String nickName) {
		super();  // 新增用
		this.memName = memName;
		this.memEmail = memEmail;
		this.memPassword = memPassword;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.nickName = nickName;
	}
	public MemberBean(int memNo, String memName, String memEmail, String memPassword, int gender, String birth, int age,
			String phone, String regDate, int status, String nickName, byte[] memPic) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memEmail = memEmail;
		this.memPassword = memPassword;
		this.gender = gender;
		this.birth = birth;
		this.age = age;
		this.phone = phone;
		this.regDate = regDate;
		this.status = status;
		this.nickName = nickName;
		this.memPic = memPic;
	}
	public MemberBean() {
		super();
	}
	@Override
	public String toString() {
		return "MemberBean [memNo=" + memNo + ", memName=" + memName + ", memEmail=" + memEmail + ", memPassword="
				+ memPassword + ", gender=" + gender + ", birth=" + birth + ", age=" + age + ", phone=" + phone
				+ ", regDate=" + regDate + ", status=" + status + ", nickName=" + nickName + "]";
	}

	
}
