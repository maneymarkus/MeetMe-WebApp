//----------------------------------------------------
// 20.06.2018 - Carloss
// War bereits so vorgegeben - KEINE Änderungen

package de.tub.ise.as.td.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.ise.as.td.entity.User;

@Stateless
public class UserManagement {
	
	@PersistenceContext
	EntityManager em;
	
	@EJB
	UserInit userInit;
	
	public List<User> getUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}
	
}



//20.06.2018 - Carloss ENDE------------------------------------------------