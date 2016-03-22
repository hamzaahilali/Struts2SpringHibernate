package com.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.User;
import com.web.service.MyServiceImpl;
import com.web.service.MyServiceInterface;

public class LoginAction extends ActionSupport implements SessionAware, ServletResponseAware {

	Map<String, Object> session;
	private String userName;
	private String password;
	private String email;
	private MyServiceInterface myService;
	private HttpServletResponse response;

	@Override
	public String execute() throws Exception {
		User user = getMyService().authenticateUser(getUserName(), getPassword());
		System.out.println("after get user" + user.getUserName());
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		System.out.println("user name isssssssssssssssssssssssssss " + user.getUserName());
		if (!(user.getUserName() == null)) {
			System.out.println("Suscess");
			session.put("user", user);
			session.put("userName", user.getUserName());
			response.getWriter().print("success");
		} else {
			System.out.println("input");
			response.getWriter().print("input");

		}
		response.getWriter().flush();
		response.getWriter().close();
		System.out.println("sucesss");
		return Action.SUCCESS;
	}

	@Override
	public void validate() {

		/* Check that fields are not empty */
		if (getPassword().length() == 0) {
			addFieldError("password", getText("password.required"));
		}
		if (getUserName().length() == 0) {
			addFieldError("userName", getText("userMame.required"));
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}

}
