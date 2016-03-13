package com.web.model;

import javax.persistence.Embeddable;

@Embeddable
public class Camera {
	private double frontCamera;
	private double rearCamera;

	public Camera() {

	}

	public Camera(double frontCamera, double rearCamera) {
		this.frontCamera = frontCamera;
		this.rearCamera = rearCamera;
	}

	public double getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(double frontCamera) {
		this.frontCamera = frontCamera;
	}

	public double getRearCamera() {
		return rearCamera;
	}

	public void setRearCamera(double rearCamera) {
		this.rearCamera = rearCamera;
	}

}
