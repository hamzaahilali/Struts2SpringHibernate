package com.web.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.Shoe;
import com.web.service.MyServiceInterface;

public class AdminAction extends ActionSupport implements ModelDriven<Shoe> {
	MyServiceInterface myService;
	Collection listOfShoe;
	private List<String> shoeColors;
	private List<Integer> shoeSizes;
	private Shoe shoe = new Shoe();;

	public Shoe getShoe() {
		return shoe;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}

	public List<Integer> getShoeSizes() {
		return shoeSizes;
	}

	public void setShoeSizes(List<Integer> shoeSizes) {
		this.shoeSizes = shoeSizes;
	}

	public List<String> getShoeColors() {
		return shoeColors;
	}

	public void setShoeColors(List<String> shoeColors) {
		this.shoeColors = shoeColors;
	}

	public Collection getListOfShoe() {
		return listOfShoe;
	}

	public void setListOfShoe(Collection listOfShoe) {
		this.listOfShoe = listOfShoe;
	}

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public String getShoes() throws Exception {
		listOfShoe = myService.getListOfItem("Shoe");
		return SUCCESS;
	}

	public String deleteShoes() throws Exception {
		listOfShoe = myService.getListOfItem("Shoe");
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		listOfShoe = myService.getListOfItem("Shoe");
		return SUCCESS;
	}

	public String retrieveShoe() {
		this.shoe = myService.getShoe(this.shoe.getItemID());
		return SUCCESS;
	}

	public String addShoe() {
		System.out.print(myService.persistShoe(shoe));
		return SUCCESS;
	}

	public String deleteShoe() {
		myService.deleteShoe(shoe.getItemID());
		return SUCCESS;
	}

	public String updateShoe() {
		myService.updateShoe(shoe);
		return SUCCESS;
	}

	public Shoe getModel() {
		return shoe;
	}

	public AdminAction() {
		shoeColors = new ArrayList<String>();
		shoeColors.add("Red");
		shoeColors.add("Blue");
		shoeColors.add("Green");
		shoeColors.add("White");
		shoeColors.add("Black");
		shoeColors.add("Gray");
		shoeColors.add("Yellow");
		shoeColors.add("Pink");
		Collections.sort(shoeColors);
		shoeSizes = new ArrayList<Integer>();
		for (int i = 28; i < 46; i++) {
			shoeSizes.add(i);
		}
	}
}
