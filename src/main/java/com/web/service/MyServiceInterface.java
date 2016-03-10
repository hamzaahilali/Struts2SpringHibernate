package com.web.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.web.model.Admin;
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
}
