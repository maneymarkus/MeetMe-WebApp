package de.tub.ise.as.td.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERTABLE")
public class User implements Serializable {
	private static final long serialVersionUID = -577432887255987479L;
	@Id
	@GeneratedValue
	int id;
	int age;
	String name;
	String starsign;
	String course;
	
	public User() {
		super();
	}
	
	public User(String name) {
		this.name = name;
	}

	public User(String name, String starsign) {
		this(name);
		this.starsign = starsign;
	}
	
	public User(String name, String starsign, String course) {
		this(name, starsign);
		this.course = course;
	}
	
	public User(String name, int age, String starsign, String course) {
		this(name, starsign, course);
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getStarsign() {
		return starsign;
	}

	public void setStarsign(String starsign) {
		this.starsign = starsign;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
