package com.web.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.web.model.Admin;
import com.web.model.Mobile;
import com.web.model.MobileCase;
import com.web.model.PowerBank;
import com.web.model.Shoe;
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

	public User authenticateUser(String username, String password) {
		System.out.println("Authenticating: username = " + username);

		User validUser = null;

		Query query = entityManager.createQuery("from User where username = :username").setParameter("username",
				username);

		List result = query.getResultList();
		if (!result.isEmpty()) {

			User user = (User) result.get(0);

			/* If the username mapped to a real user, check password */
			if (user != null && user.getPassword().equals(password)) {
				validUser = user;
			}
		}

		return validUser;
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
		// TODO Auto-generated method stub

	}

	public String persistShoe(Shoe shoe) {
		System.out.println(shoe.getName());
		entityManager.persist(shoe);
		return shoe.getName();// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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

	public void updateMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		System.out.println(mobile.getName() + " updating");

		Mobile updateMobile = this.getMobile(mobile.getItemID());
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
		// System.out.println("update");
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
}
