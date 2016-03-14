package com.web.model;

import javax.persistence.Entity;

@Entity
public class MobileCase extends Accessory {
	public MobileCase() {
	}

	public MobileCase(String name, long price, String color, String pic, String description, String type) {
		super(name, price, color, pic, description, type);
	}
}
