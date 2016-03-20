package com.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.User;
import com.web.service.MyServiceInterface;

public class UserAction extends ActionSupport implements ModelDriven<User>, SessionAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private MyServiceInterface myService;
	private Map<String, Object> session;
	private HttpServletResponse response;

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public String register() throws Exception {

		boolean isUserExist = getMyService().authenticateEmail(user.getEmail());
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		if (isUserExist) {
			response.getWriter().print("input");
		} else {
			myService.persistUser(user);
			response.getWriter().print("success");
		}
		response.getWriter().flush();
		response.getWriter().close();
		return SUCCESS;
	}

	public String login() throws Exception {
		User validUser = getMyService().authenticateUser(user.getUserName(), user.getPassword());
		System.out.println("after get user" + validUser.getUserName());
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		if (!(validUser.getUserName() == null)) {
			System.out.println("Suscess");
			session.put("user", validUser);
			session.put("userName", validUser.getUserName());
			System.out.println("session put " + validUser.getUserName());
			response.getWriter().print("success");
			//response.setStatus(500);
			
		} else {
			//response.setStatus(401);
			System.out.println("input");
			response.getWriter().print("input");

		}
		response.getWriter().flush();
		response.getWriter().close();
		System.out.println("sucesss");
		return Action.SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
