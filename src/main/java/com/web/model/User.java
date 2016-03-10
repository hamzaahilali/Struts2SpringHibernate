package com.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long userId;

	private String userName;
	private String email;
	private String password;
	

	@OneToMany
	private Collection<ShoppingCart> Orders = new ArrayList<ShoppingCart>();

	public Collection<ShoppingCart> getOrders() {
		return Orders;
	}

	public void setOrders(Collection<ShoppingCart> orders) {
		Orders = orders;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
