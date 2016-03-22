package com.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

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

@Transactional
public class MyServiceImpl implements MyServiceInterface {

	private EntityManager entityManager;
	private String imageLocation;

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean userExists(String username) {

		Query query = entityManager.createQuery("from User where username = :username").setParameter("username",
				username);
		List result = query.getResultList();

		return !result.isEmpty();

	}

	public void updateUser(User user) {
		entityManager.merge(user);

	}

	public User authenticateUser(String userNameOrEmail, String password) {
		System.out.println("Authenticating: username = " + userNameOrEmail);

		User validUser = new User();
		Query query;
		String ss = new String("@");
		System.out.println(userNameOrEmail.contains(ss));

		if (userNameOrEmail.contains(ss)) {
			System.out.println("contain @");
			query = entityManager.createQuery("from User where email = :username").setParameter("username",
					userNameOrEmail);
		} else {
			System.out.println("valid userName");
			query = entityManager.createQuery("from User where userName = :username").setParameter("username",
					userNameOrEmail);
		}

		List result = query.getResultList();
		if (!result.isEmpty()) {

			User user = (User) result.get(0);
			System.out.println("get 0 ");
			/* If the username mapped to a real user, check password */
			if (user != null && user.getPassword().equals(password)) {
				validUser = user;
				System.out.println("not null");
			}
		}

		if (validUser == null) {
			System.out.println("null user");
		}
		// System.out.println("valid user" + validUser.getUserName());
		return validUser;
	}

	public boolean authenticateEmail(String email) {
		System.out.println("email register:" + email);
		Query query = entityManager.createQuery("from User where email = :email").setParameter("email", email);
		User user = new User();
		List resultList = query.getResultList();
		System.out.println("Does exsit? " + (!resultList.isEmpty()));
		return (!resultList.isEmpty());
	}

	public Collection getUsers() {
		Query query = entityManager.createQuery("from User");

		return query.getResultList();

	}

	public User getUser(String username) {
		Query query = entityManager.createQuery("from User where username = :username");
		query.setParameter("username", username);

		User user = (User) query.getSingleResult();

		return user;

	}

	public User getUser(Long id) {
		User user = entityManager.find(User.class, id);

		return user;

	}

	public Collection getListOfItem(String typeOfItem) {
		String HQL = "From " + typeOfItem;
		Query query = entityManager.createQuery(HQL);
		List listOfItem = query.getResultList();

		return listOfItem;
	}

	public Shoe getShoe(long id) {
		System.out.println("get Shoeeeeeeeeeeeeeeeeeeeee");
		Shoe shoe = entityManager.find(Shoe.class, id);
		System.out.println(shoe.getName() + "asdasdas");
		return shoe;

	}

	public Admin authenticateAdmin(String adminName, String password) {

		Admin validAdmin = null;

		Query query = entityManager.createQuery("from Admin where adminName = :adminName").setParameter("adminName",
				adminName);

		List result = query.getResultList();
		if (!result.isEmpty()) {

			Admin admin = (Admin) result.get(0);

			/* If the username mapped to a real user, check password */
			if (admin != null && admin.getPassword().equals(password)) {
				validAdmin = admin;
			}
		}

		return validAdmin;
	}

	public void deleteShoe(long id) {

		Shoe oldShoe = entityManager.find(Shoe.class, id);
		if (oldShoe != null) {
			System.out.println(oldShoe.getName() + " is deleted");
			entityManager.remove(oldShoe);
		}

	}

	public void persistUser(User user) {
		entityManager.persist(user);

	}

	public void changeStatus(long id) {

	}

	public String persistShoe(Shoe shoe) {
		System.out.println(shoe.getName());
		entityManager.persist(shoe);
		return shoe.getName();
	}

	public void updateShoe(Shoe shoe) {
		System.out.println(shoe.getName() + " updating");

		Shoe updateShoe = entityManager.find(Shoe.class, shoe.getItemID());
		updateShoe.setName(shoe.getName());
		updateShoe.setPrice(shoe.getPrice());
		updateShoe.setPic(shoe.getPic());
		updateShoe.setShoeSize(shoe.getShoeSize());
		updateShoe.setColor(shoe.getColor());
		entityManager.merge(updateShoe);
	}

	public void persistMobile(Mobile mobile) {
		entityManager.persist(mobile);
	}

	public void persistMobileCase(MobileCase mobileCase) {
		entityManager.persist(mobileCase);
	}

	public void persistPowerBank(PowerBank powerBank) {
		entityManager.persist(powerBank);
	}

	public Mobile getMobile(long id) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		System.out.println(mobile.getAccessories().size());
		return mobile;
	}

	public Mobile getMobileWithAccessory(long id) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		System.out.println(mobile.getAccessories().size());
		return mobile;
	}

	public MobileCase getMobileCase(long id) {
		MobileCase mobileCase = entityManager.find(MobileCase.class, id);
		return mobileCase;
	}

	public PowerBank getPowerBank(long id) {
		PowerBank powerBank = entityManager.find(PowerBank.class, id);
		return powerBank;
	}

	public void deleteMobile(long id) {
		System.out.println("Enter delete mobile");
		Mobile mobile = this.getMobile(id);
		System.out.println("Delete mobile" + mobile.getName());
		if (mobile != null)
			entityManager.remove(mobile);
	}

	public void deleteMobileCase(long id) {
		MobileCase mobileCase = this.getMobileCase(id);
		if (mobileCase != null)
			entityManager.remove(mobileCase);
	}

	public void deletePowerBank(long id) {
		PowerBank powerBank = this.getPowerBank(id);
		if (powerBank != null)
			entityManager.remove(powerBank);
	}

	public void updateMobile(Mobile mobile, List<String> mobileAccessoriesName) {

		System.out.println(mobile.getName() + " updating");
		List<String> oldMobileAccessoriesName = new ArrayList<String>();

		Mobile updateMobile = entityManager.find(Mobile.class, mobile.getItemID());
		System.out.println(updateMobile.getAccessories().size() + "size");
		for (Accessory acc : updateMobile.getAccessories()) {
			System.out.println(acc.getName());
			oldMobileAccessoriesName.add(acc.getName());
		}
		if (!oldMobileAccessoriesName.equals(mobileAccessoriesName)) {
			updateMobile.getAccessories().clear();
			for (String name : mobileAccessoriesName) {
				String pic = name.replaceAll("\\s", "");
				Accessory acc = this.getAccessory(pic);
				System.out.println(acc.getName() + "acc name");
				updateMobile.getAccessories().add(acc);
				// entityManager.merge(acc);
			}

		}
		// for (String name : mobileAccessoriesName) {
		// System.out.println(name + "new acc");
		// if (!oldMobileAccessoriesName.contains(name)) {
		//
		// String pic = name.replaceAll("\\s", "");
		// System.out.println(pic + "trim");
		// Accessory acc = this.getAccessory(pic);
		// System.out.println(acc.getName() + "acc name");
		// updateMobile.getAccessories().add(acc);
		// acc.getMobiles().add(updateMobile);
		// entityManager.merge(acc);
		// }
		// }

		updateMobile.setName(mobile.getName());
		updateMobile.setPrice(mobile.getPrice());
		updateMobile.setPic(mobile.getPic());
		updateMobile.setColor(mobile.getColor());
		updateMobile.setCamera(mobile.getCamera());
		updateMobile.setInternalStorage(mobile.getInternalStorage());
		updateMobile.setIsSupportExternalCard(mobile.getIsSupportExternalCard());
		updateMobile.setOperatingSystem(mobile.getOperatingSystem());
		updateMobile.setRam(mobile.getRam());
		updateMobile.setScreen(mobile.getScreen());
		updateMobile.setDescription(mobile.getDescription());
		System.out.println("update");

		entityManager.merge(updateMobile);
	}

	public void updateMobileCase(MobileCase mobileCase) {
		System.out.println(mobileCase.getName() + " updating");

		MobileCase updateMobileCase = this.getMobileCase(mobileCase.getItemID());
		updateMobileCase.setName(mobileCase.getName());
		updateMobileCase.setPrice(mobileCase.getPrice());
		updateMobileCase.setPic(mobileCase.getPic());
		updateMobileCase.setColor(mobileCase.getColor());
		updateMobileCase.setDescription(mobileCase.getDescription());
		entityManager.merge(updateMobileCase);

	}

	public void updatePowerBank(PowerBank powerBank) {
		System.out.println(powerBank.getName() + " updating");

		PowerBank updatePowerBank = this.getPowerBank(powerBank.getItemID());
		updatePowerBank.setName(powerBank.getName());
		updatePowerBank.setPrice(powerBank.getPrice());
		updatePowerBank.setPic(powerBank.getPic());
		updatePowerBank.setColor(powerBank.getColor());
		updatePowerBank.setCapacity(powerBank.getCapacity());
		updatePowerBank.setDescription(powerBank.getDescription());
		entityManager.merge(updatePowerBank);
	}

	public Collection<Accessory> getAllAccessories() {
		Query query = entityManager.createQuery("from Accessory");
		return query.getResultList();
	}

	public Collection<String> getAllAccessoriesName() {
		Query query = entityManager.createQuery("select name from Accessory");
		return query.getResultList();
	}

	public Collection<Accessory> getMobileCases() {
		Query query = entityManager.createQuery("from MobileCase");
		return query.getResultList();
	}

	public Collection<Accessory> getPowerBanks() {
		Query query = entityManager.createQuery("from PowerBank");
		return query.getResultList();
	}

	public Collection getMobileCasesName() {
		Query query = entityManager.createQuery("select name from MobileCase");
		return query.getResultList();

	}

	public Collection getPowerBanksName() {
		Query query = entityManager.createQuery("select name from PowerBank");
		return query.getResultList();

	}

	public Accessory getAccessory(String pic) {
		System.out.println(pic);

		Query query = entityManager.createQuery("from Accessory Where pic = :pic");
		query.setParameter("pic", pic);
		return (Accessory) query.getSingleResult();
	}

	public Item getItem(long id) {
		System.out.println(id);

		Query query = entityManager.createQuery("from Item Where itemID = :id");
		query.setParameter("id", id);
		return (Item) query.getSingleResult();

	}

	public void persistShoppingCart(ShoppingCart shoppingCart) {
		System.out.println("1");
		for (OrderedItem tmpOrderedItem : shoppingCart.getOrderedItems()) {
			Item tmpItem = entityManager.find(Item.class, tmpOrderedItem.getItem().getItemID());
			tmpOrderedItem.setItem(tmpItem);
			System.out.println("2");
			entityManager.persist(tmpOrderedItem);
		}
		System.out.println("3");
		User user = entityManager.find(User.class, shoppingCart.getUser().getUserId());
		shoppingCart.setUser(user);
		System.out.println("4");
		entityManager.persist(shoppingCart);
		System.out.println("5");
	}

	public void persistOrderedItem(OrderedItem orderedItem) {
		entityManager.persist(orderedItem);

	}

	public Collection<ShoppingCart> getAllShoppingCart() {
		Query query = entityManager.createQuery("from ShoppingCart");

		return query.getResultList();
	}

	public ShoppingCart getShoppingCart(long id) {
		ShoppingCart shoppinCart = entityManager.find(ShoppingCart.class, id);
		System.out.print("shopping cart size ");
		System.out.println(shoppinCart.getOrderedItems().size());
		return shoppinCart;
	}

	public Mobile getMobileWithAccessory(String uniqueName) {
		System.out.println(uniqueName);

		Query query = entityManager.createQuery("from Mobile Where uniqueName = :uniqueName");
		query.setParameter("uniqueName", uniqueName);
		Mobile mobile = (Mobile) query.getSingleResult();
		System.out.println(mobile.getAccessories().size());
		return mobile;

	}

	public MobileCase getMobileCase(String uniqueName) {
		System.out.println(uniqueName);

		Query query = entityManager.createQuery("from MobileCase Where uniqueName = :uniqueName");
		query.setParameter("uniqueName", uniqueName);
		MobileCase mobileCase = (MobileCase) query.getSingleResult();
		return mobileCase;
	}

	public PowerBank getPowerBank(String uniqueName) {
		System.out.println(uniqueName);

		Query query = entityManager.createQuery("from PowerBank Where uniqueName = :uniqueName");
		query.setParameter("uniqueName", uniqueName);
		PowerBank powerBank = (PowerBank) query.getSingleResult();
		return powerBank;
	}

	public void updateShoppingCart(long id, String status) {
		ShoppingCart tmp = this.getShoppingCart(id);
		tmp.setStatus(status);
		entityManager.merge(tmp);
		System.out.println("exit ");
	}

}
