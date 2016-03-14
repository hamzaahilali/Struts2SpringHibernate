package com.web.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionOfElements;

@Entity
public class Mobile extends Item {
	private String operatingSystem;
	private int ram;
	private int internalStorage;
	@Embedded
	private Screen screen;
	@Embedded
	private Camera camera;
	private Boolean isSupportExternalCard;

	@ManyToMany(targetEntity = Accessory.class)
	private Collection<Accessory> accessories = new ArrayList<Accessory>();

	public Mobile() {
	}

	public Mobile(String operatingSystem, int ram, int internalStorage, Screen screen, Camera camera,
			boolean isSupportExternalCard, String type) {

		this.operatingSystem = operatingSystem;
		this.ram = ram;
		this.internalStorage = internalStorage;
		this.screen = screen;
		this.camera = camera;
		this.isSupportExternalCard = isSupportExternalCard;

	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getInternalStorage() {
		return internalStorage;
	}

	public void setInternalStorage(int internalStorage) {
		this.internalStorage = internalStorage;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Boolean getIsSupportExternalCard() {
		return isSupportExternalCard;
	}

	public void setIsSupportExternalCard(Boolean isSupportExternalCard) {
		this.isSupportExternalCard = isSupportExternalCard;
	}

	public Collection<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(Collection<Accessory> accessories) {
		this.accessories = accessories;
	}

}
