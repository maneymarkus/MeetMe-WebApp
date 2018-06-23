package de.tub.ise.as.td.ejb;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
	EntityManager emp;

	@EJB
	PostInit postInit;
	
	public List<Post> getPosts() {
		TypedQuery<Post> query = emp.createQuery("SELECT p FROM Post p", Post.class);
		return query.getResultList();
	}
	
	public List<Post> getPosts(int destId) {
		TypedQuery<Post> query = emp.createQuery("SELECT p FROM Post p WHERE p.destinationID=" + destId, Post.class);
		System.out.println(query.getResultList().size());
		return query.getResultList();
	}
	
	public String setPosting(String author, int targetId, String content) {
		System.out.println("hallo");
		/*
		long timeStamp = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Date resultDate = new Date(timeStamp);
		Post post = new Post(targetId, content, author, timeStamp);
		em.persist(post);
		//System.out.println(timeStamp);
		return sdf.format(resultDate);*/
		return "answer";
	}
	
}


//20.06.2018 - Carloss ENDE--------------------------------------------------