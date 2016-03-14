package com.web.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.Accessory;
import com.web.model.Item;
import com.web.model.Mobile;
import com.web.service.MyServiceInterface;

public class MobileAction extends ActionSupport implements ProductActionInterface, ModelDriven<Mobile> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mobile mobile = new Mobile();
	private MyServiceInterface myService;
	private List<String> allAccessoriesName = new ArrayList<String>();
	private List<String> mobileAccessoriesName = new ArrayList<String>();

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

	public List<String> getAllAccessoriesName() {
		return allAccessoriesName;
	}

	public void setAllAccessoriesName(List<String> allAccessoriesName) {
		this.allAccessoriesName = allAccessoriesName;
	}

	public List<String> getMobileAccessoriesName() {
		return mobileAccessoriesName;
	}

	public void setMobileAccessoriesName(List<String> mobileAccessoriesName) {
		this.mobileAccessoriesName = mobileAccessoriesName;
	}

	public String showDetail() {
		mobile = myService.getMobileWithAccessory(mobile.getItemID());
		return SUCCESS;
	}

	public String editProduct() {
		mobile = myService.getMobileWithAccessory(mobile.getItemID());

		for (Accessory acc : mobile.getAccessories()) {
			mobileAccessoriesName.add(acc.getName());
		}

		allAccessoriesName = (List<String>) myService.getAllAccessoriesName();

		return SUCCESS;
	}

	public String orderProduct() {
		return SUCCESS;
	}

	public Mobile getModel() {
		return mobile;
	}

	public String deleteProduct() {
		System.out.println("ProductId " + mobile.getItemID());
		myService.deleteMobile(mobile.getItemID());
		return SUCCESS;
	}

	public String updateProduct() {
		System.out.println(mobileAccessoriesName.size() + "mbbbb");
		myService.updateMobile(mobile, mobileAccessoriesName);
		return SUCCESS;
	}

}
