package com.example.websocketdemo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
private long id;
private String username;
private String email;
private String password;
public users(long id, String username, String email, String password) {
	super();
	this.id = id;
	this.username = username;
	this.email = email;
	this.password = password;
}
public users() {
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
