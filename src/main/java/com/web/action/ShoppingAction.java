package com.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.factory.MobileFacetory;
import com.web.model.Item;
import com.web.model.Mobile;
import com.web.model.OrderedItem;
import com.web.model.ShoppingCart;
import com.web.model.User;
import com.web.service.MyServiceInterface;
import com.web.model.OrderedItem;

public class ShoppingAction extends ActionSupport implements ModelDriven<Item>, SessionAware, ServletResponseAware {

	Map<String, Object> session;

	private Collection<OrderedItem> orederdItemsInShoppingCart = new ArrayList<OrderedItem>();
	private MyServiceInterface myService;
	private ShoppingCart shoppingCart;
	private HttpServletResponse response;
	private HashMap<Long, OrderedItem> mapOrderedItems = new HashMap<Long, OrderedItem>();
	private HashMap<String, Object> jsonData = new HashMap<String, Object>();
	private Item item = new Item();

	public String deleteItem() {

		HashMap<Long, OrderedItem> tmpMap = (HashMap<Long, OrderedItem>) session.get("mapOrderedItems");
		OrderedItem tmp = (OrderedItem) tmpMap.get(item.getItemID());

		session.put("totalAmount", ((Long) session.get("totalAmount")) - new Long(tmp.getAmount()));
		session.put("totalPrice", ((Long) session.get("totalPrice")) - tmp.getAmount() * tmp.getItem().getPrice());

		System.out.println((Long) session.get("totalPrice") + "total");
		tmpMap.remove(item.getItemID());

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		try {
			response.getWriter().print((Long) session.get("totalPrice"));
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String addItem() {

		System.out.println(this.item + "item");
		System.out.println("itemID" + this.getModel().getItemID());

		if (session.get("mapOrderedItems") == null) {
			session.put("mapOrderedItems", new HashMap<Long, OrderedItem>());

		}
		if (session.get("totalAmount") == null) {
			session.put("totalAmount", new Long(0));
		}
		if (session.get("totalPrice") == null) {
			session.put("totalPrice", new Long(0));
		}

		@SuppressWarnings("rawtypes")
		HashMap<Long, OrderedItem> tmpMap = (HashMap<Long, OrderedItem>) session.get("mapOrderedItems");
		System.out.println(tmpMap.size());
		session.put("totalAmount", (Long) session.get("totalAmount") + new Long(1));

		if (tmpMap.containsKey(item.getItemID())) {
			OrderedItem tmp = (OrderedItem) tmpMap.get(item.getItemID());
			System.out.println("Cong 1 " + tmp.getItem().getName());
			tmp.setAmount(tmp.getAmount() + 1);
			tmpMap.put(item.getItemID(), tmp);
		} else {
			OrderedItem newOrderedItem = new OrderedItem();
			newOrderedItem.setItem(item);
			newOrderedItem.setAmount(1);
			System.out.println("them moi " + newOrderedItem.getItem().getName());
			tmpMap.put(item.getItemID(), newOrderedItem);
		}

		System.out.println("itemID: " + item.getItemID());
		System.out.println("size " + tmpMap.size());
		session.put("mapOrderedItems", tmpMap);

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		try {
			response.getWriter().print(this.item.getName() + " is added <br>" + session.get("totalAmount").toString()
					+ " items in your shopping cart");
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public String getTotalItemAmount() {
		System.out.println("gettooooooooooooooo");
		response.setContentType("application/json");

		jsonData.put("totalAmount", (Long) session.get("totalAmount"));

		String json = new Gson().toJson((Long) session.get("totalAmount"));
		try {
			response.getWriter().print(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	@SuppressWarnings("rawtypes")
	public String viewShoppingCart() {

		System.out.println("enter View Shopping");
		@SuppressWarnings("rawtypes")

		HashMap mapOrderedItems = (HashMap) session.get("mapOrderedItems");

		shoppingCart = new ShoppingCart();
		shoppingCart.setCreatedDate(new Date());

		if (mapOrderedItems != null) {
			Iterator itr = mapOrderedItems.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry entry = (Entry) itr.next();
				orederdItemsInShoppingCart.add((OrderedItem) entry.getValue());
				System.out.println((OrderedItem) entry.getValue());
			}
		}
		shoppingCart.setOrderedItems(orederdItemsInShoppingCart);

		session.put("totalPrice", shoppingCart.calculteTotalPrice());

		System.out.println("Success");
		return SUCCESS;
	}

	public String buy() {
		// shoppingCart = (ShoppingCart) session.get("shoppingCart");
		// shoppingCart.setStatus("On going");
		// for (OrderedItem orderedItem : shoppingCart.getOrderedItems()) {
		// myService.persistOrderedItem(orderedItem);
		// }
		// User user = (User) session.get("user");
		// user = myService.getUser(user.getUserId());
		// shoppingCart.setUser(user);
		// myService.persistShoppingCart(shoppingCart);

		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Collection<OrderedItem> getOrederdItemsInShoppingCart() {
		return orederdItemsInShoppingCart;
	}

	public void setOrederdItemsInShoppingCart(Collection<OrderedItem> orederdItemsInShoppingCart) {
		this.orederdItemsInShoppingCart = orederdItemsInShoppingCart;
	}

	public MyServiceInterface getMyService() {
		return myService;
	}

	public void setMyService(MyServiceInterface myService) {
		this.myService = myService;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public void setServletResponse(HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		this.response = reponse;
	}

	public Item getModel() {
		return item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
