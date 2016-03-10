package com.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue
	private long shoppingCartID;


	private String status;
	private Date createdDate;
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToMany(mappedBy = "shoppingCarts")
	Collection<Item> items = new ArrayList<Item>();

	

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}
	public long getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(long shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}
}
