package de.tub.ise.as.td.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.tub.ise.as.td.entity.User;

@Singleton
@Startup
public class UserInit {
	@PersistenceContext
	EntityManager em;

	@PostConstruct
	public void ensureUsersExist() {
		User user = new User("Peter", 32, "Schütze", "WInf", "./images/Peter.jpg");
		em.persist(user);
		user = new User("Dennis", 18, "Skorpion", "Physik", "./images/Dennis.jpg");
		em.persist(user);
		user = new User("Chris", 21, "Löwe", "WInf", "./images/Chris.jpg");
		em.persist(user);
		user = new User("Markus", 19, "Löwe", "WInf", "./images/Markus.jpg");
		em.persist(user);
	}
}
