package com.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MEMBER")
public class Member implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MEMBER_CODE")
	private String membercode;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="MEMBER_TYPE")
	private String membertype;	

	@Column(name="PASSWORD")
	private String password;

	@Column(name="PHONE")
	private String phone;

	@Column(name="USER_NAME")
	private String username;	

	@Column(name="SALARY")
	private int salary;

	

	public Member() {}

	public Member(String membercode , String address , String membertype , String password , String phone ,String username , int salary) {

		this.membercode = membercode;
		this.address = address;
		this.membertype = membertype;
		this.password = password;
		this.phone = phone;
		this.username = username;
		this.salary = salary;
	}


	public String getMembercode() {
		return membercode;
	}

	public void setMembercode(String membercode) {
		this.membercode = membercode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMembertype() {
		return membertype;
	}

	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}

