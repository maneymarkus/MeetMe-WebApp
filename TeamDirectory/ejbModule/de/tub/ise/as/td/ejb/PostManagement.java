package de.tub.ise.as.td.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.tub.ise.as.td.entity.Post;

@Stateless
public class PostManagement {
	
	@PersistenceContext
	EntityManager em;
	
	@EJB
	PostInit postInit;
	
	public List<Post> getPosts() {
		TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p", Post.class);
		return query.getResultList();
	}
	
}
