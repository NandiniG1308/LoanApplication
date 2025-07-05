package com.project.capstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Column(columnDefinition = "varchar(20)")
	private String userName;
	@Id
	@Column(columnDefinition = "varchar(20)")
	private String email;
	@Size(min = 10, max = 10)
	private String phoneNo;

	private String address;

	@Size(min = 8, message = "Should contain atleast 8 charcters with atleast one special charcter,one captial letter and one numeric value", max = 15)
	private String password;
	
	

	public User(String userName, String email, @Size(min = 10, max = 10) String phoneNo, String address,
			@Size(min = 8, message = "Should contain atleast 8 charcters with atleast one special charcter,one captial letter and one numeric value", max = 15) String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.password = password;
	}

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
