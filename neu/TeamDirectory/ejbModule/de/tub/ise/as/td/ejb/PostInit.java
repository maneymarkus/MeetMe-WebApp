//----------------------------------------------------
// 20.06.2018 - Carloss
// Erstellen von Standardbenutzerdaten laut Vorgabe
// Hinzufügen zur DB
// "toString"-Methode (zu Testzwecken)

package de.tub.ise.as.td.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.tub.ise.as.td.entity.Post;

@Singleton
@Startup
public class PostInit {
	@PersistenceContext
	EntityManager em;

	@PostConstruct
	public void ensurePostsExist() {
		
		List<Post> postList = new ArrayList<>();
		
		
		//int destinationID, String content, String author, long timeStamp
		
		Post admin = new Post(1, "Lass es krachen", "Icke", System.currentTimeMillis());
		em.persist(admin);
		postList.add(admin);
		admin = new Post(1, "Haste Geburtstag?", "BUZZER", System.currentTimeMillis());
		em.persist(admin);
		postList.add(admin);
		admin = new Post(2, "Komm ma uffn Kiez", "DerLetzteLude43", System.currentTimeMillis());
		em.persist(admin);
		postList.add(admin);
		admin = new Post(3, "Ihr Verhalten ist höchst infantil", "PoliticalCorrectness", System.currentTimeMillis());
		em.persist(admin);
		postList.add(admin);
		
		//System.out.println(toString(postList));
		
	}
	
	
	public String toString(List<Post> postList) {
		StringBuffer ausgabe = new StringBuffer();
		
		for(Post p : postList) {
			ausgabe.append("Ziel-ID: " + p.getDestinationID() + 
					" Post-ID: " + p.getId() + 
					" Verfasser: " + p.getAuthor() + 
					" Inhalt: " + p.getContent() + 
					" Zeit: " + p.getTimeStamp() + 
					"\n");
		}
		
		return ausgabe.toString();
	}
	
	public String done() {
		return "-----------------------------------------------------------------------";
	}
}


//20.06.2018 - Carloss ENDE--------------------------------------------