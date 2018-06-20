package de.tub.ise.as.td.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POSTTABLE")
public class Post implements Serializable {
	private static final long serialVersionUID = -577432887255987480L; // Der Code ist korrekt?! Einfach ausgedacht!
	@Id
	@GeneratedValue
	int id;
	int destinationID;
	String content;
	String author;
	long timeStamp;
	
	
	public Post() {
		super();
	}
	
	public Post(int destinationID, String content, String author, long timeStamp) {
		this.destinationID = destinationID;
		this.content = content;
		this.author = author;
		this.timeStamp = timeStamp;
	}
	
	
	
	
	
	public int getDestinationID() {
		return destinationID;
	}
	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
