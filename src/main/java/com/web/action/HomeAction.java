package com.web.action;

import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.web.service.MyServiceInterface;

public class HomeAction extends ActionSupport {
	MyServiceInterface myService;
	Collection listOfShoe;
	public Collection getListOfShoe() {
		return listOfShoe;
	}

	public void setListOfShoe(Collection listOfShoe) {
		this.listOfShoe = listOfShoe;
	}

	public Collection getListOfClothes() {
		return listOfClothes;
	}

	public void setListOfClothes(Collection listOfClothes) {
		this.listOfClothes = listOfClothes;
	}

	Collection listOfClothes;

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	@Override
	public String execute() throws Exception {
		listOfShoe = myService.getListOfItem("Shoe");
		listOfClothes = myService.getListOfItem("Clothes");
		return SUCCESS;
	}

}
