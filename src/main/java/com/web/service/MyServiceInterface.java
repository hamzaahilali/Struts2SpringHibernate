package com.web.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.web.model.User;

public interface MyServiceInterface {

	public boolean userExists(String username);

	public void updateUser(User user);

	public User authenticateUser(String username, String password);

	public Collection getUsers();

	public User getUser(String username);

	public User getUser(Long id);

	public void persistUser(User user);
}
