package com.web.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.web.model.User;

@Transactional
public class MyServiceImpl implements MyServiceInterface {

	private EntityManager entityManager;

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

	public void persistUser(User user) {
		entityManager.persist(user);

	}
}
