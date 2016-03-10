package com.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.web.model.Shoe;
import com.web.service.MyServiceInterface;

public class ProductAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long itemID;
	private Shoe shoe;
	private MyServiceInterface myService;

	public Shoe getShoe() {
		return shoe;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	@Override
	public String execute() throws Exception {
		this.shoe = myService.getShoe(this.itemID);
		return SUCCESS;
	}

}
