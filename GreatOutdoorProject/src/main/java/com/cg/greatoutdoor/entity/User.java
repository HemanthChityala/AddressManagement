package com.cg.greatoutdoor.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.greatoutdoor.GreatOutdoorProjectApplication;

@Entity
@Table(name = "userTable")
public class User {

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "USERNAME", length = 20)
	private String userName;

	@Column(name = "PASSWORD", length = 20)
	private String password;

	@Column(name = "ROLE", length = 20)
	private String role;

	@Column(name = "PHONENUMBER", length = 16)
	private String phoneNumber;

	@Column(name = "EMAIL", length = 50)
	private String email;

	public User(String userName, String password, String role, String phoneNumber, String email) {
		super();

		this.userName = userName;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public User(String userName, String password, String phoneNumber, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<Address>();

	public List<Address> getAddress() {
		Logger logger = LoggerFactory.getLogger(GreatOutdoorProjectApplication.class);
		String msg;
		msg = "INSIDE GET Address";
		logger.info(msg);
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public void addAddress(Address address) {
		Logger logger = LoggerFactory.getLogger(GreatOutdoorProjectApplication.class);
		String msg;
		msg = "INSIDE ADD Address";
		logger.info(msg);
		this.getAddress().add(address);
		address.setUser(this);
	}

}