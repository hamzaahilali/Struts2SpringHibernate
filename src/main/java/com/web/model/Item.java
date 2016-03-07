package com.web.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
public abstract class Item {
	@Id
	@GeneratedValue
	private long itemID;
	private long price;
	private String Color;
	@ManyToMany
	Collection<Order> Orders = new ArrayList<Order>();

	public Collection<Order> getOrders() {
		return Orders;
	}

	public void setOrders(Collection<Order> orders) {
		Orders = orders;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

}
