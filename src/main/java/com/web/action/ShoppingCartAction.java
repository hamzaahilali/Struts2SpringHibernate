package com.web.action;

import java.util.ArrayList;
import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.ShoppingCart;
import com.web.service.MyServiceInterface;

public class ShoppingCartAction extends ActionSupport implements ModelDriven<ShoppingCart> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
	private MyServiceInterface myService;
	private ShoppingCart shoppingCart = new ShoppingCart();
	private Long totalMoney;

	public String showDetail() {
		System.out.println("enter");
		shoppingCarts = myService.getAllShoppingCart();
		System.out.println("size");
		System.out.println(shoppingCarts.size());
		return SUCCESS;
	}

	public String showShopingCartDetail() {
		shoppingCart = myService.getShoppingCart(shoppingCart.getShoppingCartID());
		totalMoney = shoppingCart.calculteTotalPrice();
		System.out.println(shoppingCart.getOrderedItems().size());
		System.out.println("enter view spcart details");
		return SUCCESS;
	}

	public String updateShoppingCart() {
		System.out.println("enter update sc");
		System.out.println(shoppingCart.getShoppingCartID() + shoppingCart.getStatus());
		myService.updateShoppingCart(shoppingCart.getShoppingCartID(), shoppingCart.getStatus());
		return SUCCESS;
	}

	public Collection<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(Collection<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public ShoppingCart getModel() {
		// TODO Auto-generated method stub
		return shoppingCart;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Long getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Long totalMoney) {
		this.totalMoney = totalMoney;
	}

}
