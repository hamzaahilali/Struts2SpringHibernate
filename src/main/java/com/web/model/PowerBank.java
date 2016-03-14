package com.web.model;

import javax.persistence.Entity;

@Entity
public class PowerBank extends Accessory {
	private int capacity;

	public PowerBank() {
	}

	public PowerBank(String name, long price, String color, String pic, String description, int capacity, String type) {

		super(name, price, color, pic, description, type);
		this.capacity = capacity;

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
