package com.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private long orderID;
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

	@ManyToMany(mappedBy = "Orders")
	Collection<Item> Items = new ArrayList<Item>();

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public Collection<Item> getItems() {
		return Items;
	}

	public void setItems(Collection<Item> items) {
		Items = items;
	}

	public long caculatePrice() {
		long total = 0;
		for (Item item : Items) {
			total += item.getPrice();
		}
		return total;
	}

}
