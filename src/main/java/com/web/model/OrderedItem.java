package com.web.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderedItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long OrderedItemID;
	@ManyToOne
	private Item item;
	private long amount;

	@ManyToMany(mappedBy = "orderedItems")
	Collection<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();

	public long getOrderedItemID() {
		return OrderedItemID;
	}

	public void setOrderedItemID(long orderedItemID) {
		OrderedItemID = orderedItemID;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}
