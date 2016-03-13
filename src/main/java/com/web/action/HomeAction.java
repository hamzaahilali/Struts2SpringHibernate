package com.web.action;

import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.web.factory.MobileFacetory;
import com.web.model.Mobile;
import com.web.model.MobileCase;
import com.web.model.PowerBank;
import com.web.model.Shoe;
import com.web.service.MyServiceInterface;

public class HomeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyServiceInterface myService;
	Collection<Mobile> mobiles;
	Collection<Shoe> shoes;
	Collection<PowerBank> powerBanks;
	Collection<MobileCase> mobileCases;

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
//		MobileFacetory mobileFacetory = new MobileFacetory();
//		for (Integer i = 1; i < 7; i++) {
//			System.out.println(i);
//			Mobile mobile = mobileFacetory.getModelMobile("Phone " + i.toString());
//			MobileCase mobileCase = mobileFacetory.getMobileCase("Mobile Case " + i.toString());
//			PowerBank powerBank = mobileFacetory.getPoweBank("Power Bank " + i.toString());
//			mobile.getAccessories().add(mobileCase);
//			mobile.getAccessories().add(powerBank);
//			myService.persistMobileCase(mobileCase);
//			myService.persistPowerBank(powerBank);
//			myService.persistMobile(mobile);
//		}

		shoes = myService.getListOfItem("Shoe");
		mobiles = myService.getListOfItem("Mobile");
		mobileCases = myService.getListOfItem("MobileCase");
		powerBanks = myService.getListOfItem("PowerBank");
		return SUCCESS;
	}

	public Collection<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(Collection<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

	public Collection<Shoe> getShoes() {
		return shoes;
	}

	public void setShoes(Collection<Shoe> shoes) {
		this.shoes = shoes;
	}

	public Collection<PowerBank> getPowerBanks() {
		return powerBanks;
	}

	public void setPowerBanks(Collection<PowerBank> powerBanks) {
		this.powerBanks = powerBanks;
	}

	public Collection<MobileCase> getMobileCases() {
		return mobileCases;
	}

	public void setMobileCases(Collection<MobileCase> mobileCases) {
		this.mobileCases = mobileCases;
	}

}
