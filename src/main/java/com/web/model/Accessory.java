package com.web.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CollectionOfElements;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Accessory extends Item {

	@ManyToMany(targetEntity = Mobile.class, mappedBy = "accessories")
	private Collection<Mobile> mobiles = new ArrayList<Mobile>();

	public Accessory() {

	}

	public Accessory(String name, long price, String color, String pic, String description, String type) {
		super(name, price, color, pic, description, type);
	}

	public Collection<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobile(Collection<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

}
