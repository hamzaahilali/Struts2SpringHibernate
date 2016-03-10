package com.web.model;

import javax.persistence.Entity;

@Entity	
public class Shoe extends Item {
	private int shoeSize;

	public int getShoeSize() {
		return shoeSize;
	}

	public void setShoeSize(int shoeSize) {
		this.shoeSize = shoeSize;
	}

}
