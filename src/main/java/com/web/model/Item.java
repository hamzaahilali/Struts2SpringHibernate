package com.web.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long itemID;
	private String name;
	private String brand;
	private String uniqueName;
	private long price;
	private String color;
	private String pic;
	private String description;
	private String type;

	public Item() {
	}

	@OneToMany
	private Collection<OrderedItem> orderedItems = new ArrayList<OrderedItem>();

	public Item(String name, long price, String color, String pic, String description, String type) {
		this.name = name;
		this.price = price;
		this.color = color;
		this.pic = pic;
		this.description = description;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public Collection<OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(Collection<OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
