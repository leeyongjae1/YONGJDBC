package com.kh.jdbc.day01.stmt.member.model.vo;

import java.sql.Date;

public class Member {
	private String memberName;
	private String memberId;
	private String memberPw;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [memberName=" + memberName + ", memberId=" + memberId + ", memberPw=" + memberPw + ", genser="
				+ gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", hobby=" + hobby + ", regDate=" + regDate + "]";
	}

	private Date regDate;
	
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String string) {
		// TODO Auto-generated method stub
		
	}
	

}
