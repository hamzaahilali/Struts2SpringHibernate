package com.web.model;

import javax.persistence.Entity;

@Entity
public class Clothes extends Item {
	private String clothingSize;

	public String getClothingSize() {
		return clothingSize;
	}

	public void setClothingSize(String clothingSize) {
		this.clothingSize = clothingSize;
	}
}
