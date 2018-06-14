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
	String ding;
	
	public User() {
		super();
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(String name, String ding) {
		this.name = name;
		this.ding = ding;
	}
	
	public String getDing() {
		return this.ding;
	}
	public void setDing(String ding) {
		this.ding = ding;
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
