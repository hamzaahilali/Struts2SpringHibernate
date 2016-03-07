package com.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.User;
import com.web.service.MyServiceInterface;

public class RegisterAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
	private String password;
	private MyServiceInterface myService;
	private Map session;

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		myService.persistUser(user);
		session.put("user", user);
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
