package com.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.web.model.Admin;
import com.web.model.User;
import com.web.service.MyServiceInterface;

public class AdminLoginAction extends ActionSupport implements SessionAware {

	Map session;
	private String adminName;
	private String password;
	private String email;
	private MyServiceInterface myService;

	@Override
	public String execute() throws Exception {
		Admin admin = getMyService().authenticateAdmin(getAdminName(), getPassword());
		if (admin == null) {
			/* User not valid, return to input page. */
			return INPUT;
		} else {
			session.put("admin", admin);
		}

		return SUCCESS;
	}

	@Override
	public void validate() {

		/* Check that fields are not empty */
		if (getPassword().length() == 0) {
			addFieldError("password", "password required");
		}
		if (getAdminName().length() == 0) {
			addFieldError("adminName", "userMame required");
		}
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

}
