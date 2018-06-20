//----------------------------------------------------
// 20.06.2018 - Carloss
// Erstellen von Standardbenutzerdaten laut Vorgabe
// Hinzuf�gen zur DB
// "toString"-Methode (zu Testzwecken)


package de.tub.ise.as.td.ejb;

import java.util.ArrayList;
import java.util.List;

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
		
		List<User> userList = new ArrayList<>();
		
		
		User admin = new User("Markus", 19, "L�we aka Maschine", "Wirtschaftsinformatik");
		em.persist(admin);
		userList.add(admin);
		admin = new User("Dennis", 18, "Skorpion aka SPD", "Wirtschaftsinformatik");
		em.persist(admin);
		userList.add(admin);
		admin = new User("Chris", 21, "L�we", "Wirtschaftsinformatik");
		em.persist(admin);
		userList.add(admin);
		admin = new User("Carloss", 32, "Sch�tze", "Wirtschaftsinformatik");
		em.persist(admin);
		userList.add(admin);
		
		
		System.out.println(toString(userList));
		
	}
	
	
	public String toString(List<User> userList) {
		StringBuffer ausgabe = new StringBuffer();
		
		for(User p : userList) {
			ausgabe.append("ID: " + p.getAge() + 
					" Name: " + p.getName() + 
					" Alter: " + p.getAge() + 
					" Sternz.: " + p.getSternzeichen() + 
					" Studieng.: " + p.getStudiengang() + 
					"\n");
		}
		
		return ausgabe.toString();
	}
	
	public String done() {
		return "-----------------------------------------------------------------------";
	}
}


//20.06.2018 - Carloss ENDE-----------------------------------------