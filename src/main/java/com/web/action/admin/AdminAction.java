package com.web.action.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.Shoe;
import com.web.service.MyServiceInterface;

public class AdminAction extends ActionSupport {

	Collection mobiles;
	Collection shoes;
	Collection powerBanks;
	Collection mobileCases;

	private MyServiceInterface myService;

	public AdminAction() {
	}

	@Override
	public String execute() throws Exception {
		shoes = myService.getListOfItem("Shoe");
		mobiles = myService.getListOfItem("Mobile");
		mobileCases = myService.getListOfItem("MobileCase");
		powerBanks = myService.getListOfItem("PowerBank");
		return SUCCESS;
	}

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public Collection getMobiles() {
		return mobiles;
	}

	public void setMobiles(Collection mobiles) {
		this.mobiles = mobiles;
	}

	public Collection getShoes() {
		return shoes;
	}

	public void setShoes(Collection shoes) {
		this.shoes = shoes;
	}

	public Collection getPowerBanks() {
		return powerBanks;
	}

	public void setPowerBanks(Collection powerBanks) {
		this.powerBanks = powerBanks;
	}

	public Collection getMobileCases() {
		return mobileCases;
	}

	public void setMobileCases(Collection mobileCases) {
		this.mobileCases = mobileCases;
	}

}
