package com.web.model;

import javax.persistence.Embeddable;

@Embeddable
public class Screen {
	private String screenType;
	private double screenSize;

	public Screen() {
	}

	public Screen(String screenType, double screenSize) {
		this.screenType = screenType;
		this.screenSize = screenSize;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

}
