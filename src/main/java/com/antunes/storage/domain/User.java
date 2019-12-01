package com.antunes.storage.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.antunes.storage.enums.Profile;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6636375288636012358L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String login;
	private String password;
	private int registry;
	private int profile;
	
	
	public User(int id, String name, String login, String password, int registry, int profile) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.registry = registry;
		this.profile = profile;
	}
	
	public User() {
		
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRegistry() {
		return registry;
	}

	public void setRegistry(int registry) {
		this.registry = registry;
	}

	public Profile getProfile() {
		return Profile.toEnum(profile);
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}
	
	
	
	

}
