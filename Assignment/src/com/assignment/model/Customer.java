package com.assignment.model;

import java.sql.Date;

public class Customer {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String phone;
	private String mobile;
	private Date birthday;
	private String phone2;
	
	public Customer(int id, String fname, String lname, String email, String address, String city, String state,
			String zipcode, String phone, String mobile, Date birthday, String phone2) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.mobile = mobile;
		this.birthday = birthday;
		this.phone2 = phone2;
	}

	public Customer(String fname, String lname, String email, String address, String city, String state, String zipcode,
			String phone, String mobile, Date birthday, String phone2) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phone = phone;
		this.mobile = mobile;
		this.birthday = birthday;
		this.phone2 = phone2;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	}
	
	
	
	
