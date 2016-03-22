package com.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.MobileCase;
import com.web.service.MyServiceInterface;

public class MobileCaseAction extends ActionSupport implements ProductActionInterface, ModelDriven<MobileCase> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MobileCase mobileCase = new MobileCase();
	private MyServiceInterface myService;

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public MobileCase getMobileCase() {
		return mobileCase;
	}

	public void setMobileCase(MobileCase mobileCase) {
		this.mobileCase = mobileCase;
	}

	public String showDetail() {
		mobileCase = myService.getMobileCase(mobileCase.getUniqueName());
		System.out.println("get mobile case" + mobileCase.getName());
		return SUCCESS;
	}

	public String orderProduct() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public MobileCase getModel() {
		return mobileCase;
	}

	public String deleteProduct() {
		myService.deleteMobileCase(mobileCase.getItemID());
		return SUCCESS;
	}

	public String updateProduct() {
		myService.updateMobileCase(mobileCase);
		System.out.println("Success update MobileCAse");
		return SUCCESS;
	}

}
