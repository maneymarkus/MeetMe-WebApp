


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
	String name;
	int age;
	String sternzeichen;
	String studiengang;
	
	public User() {
		super();
	}
	
	public User(String name, int age, String sternzeichen, String studiengang) {
		this.name = name;
		this.age = age;
		this.sternzeichen = sternzeichen;
		this.studiengang = studiengang;
	}
	
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStudiengang() {
		return studiengang;
	}
	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}
	public String getSternzeichen() {
		return sternzeichen;
	}
	public void setSternzeichen(String sternzeichen) {
		this.sternzeichen = sternzeichen;
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
