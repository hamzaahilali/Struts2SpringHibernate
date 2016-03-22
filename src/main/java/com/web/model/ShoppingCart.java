package com.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long shoppingCartID;

	private String status;
	private Date createdDate;

	public Collection<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(Collection<OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	@ManyToOne
	private User user;

	@ManyToMany
	Collection<OrderedItem> orderedItems = new ArrayList<OrderedItem>();

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

	public Collection<OrderedItem> getItems() {
		return orderedItems;
	}

	public void setItems(Collection<OrderedItem> orderedItem) {
		this.orderedItems = orderedItem;
	}

	public long getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(long shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public Long calculteTotalPrice() {
		Long totalPrice = new Long(0);
		for (OrderedItem orderedItem : orderedItems) {
			totalPrice = totalPrice + orderedItem.getItem().getPrice() * orderedItem.getAmount();
		}
		return totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
