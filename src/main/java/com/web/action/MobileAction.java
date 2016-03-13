package com.web.action;

import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.Mobile;
import com.web.service.MyServiceInterface;

public class MobileAction extends ActionSupport implements ProductActionInterface, ModelDriven<Mobile> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mobile mobile = new Mobile();
	private MyServiceInterface myService;

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public String showDetail() {
		mobile = myService.getMobile(mobile.getItemID());
		System.out.println(mobile.getIsSupportExternalCard());
		return SUCCESS;
	}

	public String orderProduct() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public Mobile getModel() {
		return mobile;
	}

	public String deleteProduct() {
		System.out.println("Enter deleteProduct");
		System.out.println("ProductId " + mobile.getItemID());
		myService.deleteMobile(mobile.getItemID());
		return SUCCESS;
	}

	public String updateProduct() {
		System.out.println("Enter updateProduct");
		myService.updateMobile(mobile);
		System.out.println("update xong 232323");
		System.out.println("success update");
		return SUCCESS;
	}

}
