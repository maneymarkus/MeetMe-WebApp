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
		User user = new User("Peter", 32, "Sch�tze", "WInf");
		em.persist(user);
		user = new User("Dennis", 18, "Skorpion", "Physik");
		em.persist(user);
		user = new User("Chris", 21, "L�we", "WInf");
		em.persist(user);
		user = new User("Markus", 19, "L�we", "WInf");
		em.persist(user);
	}
}
