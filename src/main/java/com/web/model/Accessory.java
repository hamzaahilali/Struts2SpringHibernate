package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Accessory extends Item {
	public Accessory() {

	}

	public Accessory(String name, long price, String color, String pic, String description) {
		super(name, price, color, pic, description);
	}

}
