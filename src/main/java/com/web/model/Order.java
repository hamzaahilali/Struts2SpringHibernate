package com.web.model;

import java.util.ArrayList;
import java.util.Collection;

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
