package com.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.PowerBank;
import com.web.service.MyServiceInterface;

public class PowerBankAction extends ActionSupport implements ProductActionInterface, ModelDriven<PowerBank> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PowerBank powerBank = new PowerBank();
	private MyServiceInterface myService;

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public PowerBank getPowerBank() {
		return powerBank;
	}

	public void setPowerBank(PowerBank powerBank) {
		this.powerBank = powerBank;
	}

	public String showDetail() {
		powerBank = myService.getPowerBank(powerBank.getItemID());
		System.out.println("get PowerBank" + powerBank.getName());
		return SUCCESS;
	}

	public String orderProduct() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public PowerBank getModel() {
		return powerBank;
	}

	public String deleteProduct() {
		myService.deletePowerBank(powerBank.getItemID());
		return SUCCESS;
	}

	public String updateProduct() {
		myService.updatePowerBank(powerBank);
		return SUCCESS;
	}

}
