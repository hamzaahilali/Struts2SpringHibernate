package com.web.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.web.model.Accessory;
import com.web.model.Admin;
import com.web.model.Mobile;
import com.web.model.MobileCase;
import com.web.model.PowerBank;
import com.web.model.Shoe;
import com.web.model.User;

public interface MyServiceInterface {

	public boolean userExists(String username);

	public void updateUser(User user);

	public User authenticateUser(String username, String password);

	public Admin authenticateAdmin(String adminName, String password);

	public Collection getUsers();

	public User getUser(String username);

	public User getUser(Long id);

	public void persistUser(User user);

	public Collection getListOfItem(String typeOfItem);

	public void setImageLocation(String imageLocation);

	public String getImageLocation();

	public Shoe getShoe(long id);

	public void deleteShoe(long id);

	public void changeStatus(long id);

	public String persistShoe(Shoe shoe);

	public void updateShoe(Shoe shoe);

	public void persistMobile(Mobile mobile);

	public void persistMobileCase(MobileCase mobileCase);

	public void persistPowerBank(PowerBank powerBank);

	public Mobile getMobile(long id);

	public Mobile getMobileWithAccessory(long id);

	public MobileCase getMobileCase(long id);

	public PowerBank getPowerBank(long id);

	public void deleteMobile(long id);

	public void deleteMobileCase(long id);

	public void deletePowerBank(long id);

	public void updateMobile(Mobile mobile, List<String> mobileAccessoriesName);

	public void updateMobileCase(MobileCase mobileCase);

	public void updatePowerBank(PowerBank powerBank);

	public Collection getMobileCases();

	public Collection getPowerBanks();

	public Collection getMobileCasesName();

	public Collection getPowerBanksName();

	public Accessory getAccessory(String name);

	public Collection getAllAccessories();

	public Collection getAllAccessoriesName();
}
