//----------------------------------------------------
// 20.06.2018 - Carloss
// Nach Vorgabe von "UserManagement"

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
	
	// Chris Anfang
	public Post getPost(String name) {
		TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p WHERE p.author = '" + name + "'", Post.class);
		return query.getSingleResult();
		//return query.getResultList().get(0);
	}
	
	// JPA: Einfügen nicht per JPQL sondern per EntityManager ?!
//	public Post setPost() {
//		TypedQuery<Post> query = em.createQuery("", Post.class);
//	}
	// Chris Ende
	
}


//20.06.2018 - Carloss ENDE--------------------------------------------------
