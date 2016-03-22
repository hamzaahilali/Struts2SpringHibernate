package com.web.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.web.model.Accessory;
import com.web.model.Admin;
import com.web.model.Item;
import com.web.model.Mobile;
import com.web.model.MobileCase;
import com.web.model.OrderedItem;
import com.web.model.PowerBank;
import com.web.model.Shoe;
import com.web.model.ShoppingCart;
import com.web.model.User;

public interface MyServiceInterface {

	public boolean userExists(String username);

	public void updateUser(User user);

	public User authenticateUser(String username, String password);

	public boolean authenticateEmail(String email);

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

	public void persistShoppingCart(ShoppingCart shoppingCart);

	public void persistOrderedItem(OrderedItem orderedItem);

	public Mobile getMobile(long id);

	public Mobile getMobileWithAccessory(long id);

	public Mobile getMobileWithAccessory(String uniqueName);

	public MobileCase getMobileCase(long id);

	public MobileCase getMobileCase(String uniqueName);

	public PowerBank getPowerBank(long id);

	public PowerBank getPowerBank(String uniqueName);

	public void deleteMobile(long id);

	public void deleteMobileCase(long id);

	public void deletePowerBank(long id);

	public void updateMobile(Mobile mobile, List<String> mobileAccessoriesName);

	public void updateMobileCase(MobileCase mobileCase);

	public void updatePowerBank(PowerBank powerBank);

	public Item getItem(long id);

	public Collection getMobileCases();

	public Collection getPowerBanks();

	public Collection getMobileCasesName();

	public Collection getPowerBanksName();

	public Accessory getAccessory(String name);

	public Collection getAllAccessories();

	public Collection getAllAccessoriesName();

	public ShoppingCart getShoppingCart(long id);

	public Collection<ShoppingCart> getAllShoppingCart();

	public void updateShoppingCart(long id, String status);

}
