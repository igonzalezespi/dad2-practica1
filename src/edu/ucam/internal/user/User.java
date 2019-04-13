package edu.ucam.internal.user;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Number id;
	private String login;
	private String name;
	private String surname;

	public User() {
		this.setId(null);
		this.setLogin("");
		this.setName("");
		this.setSurname("");
	}

	public User(Number id, String login, String name, String surname) {
		this.setId(id);
		this.setLogin(login);
		this.setName(name);
		this.setSurname(surname);
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString() {
		return this.id + " : " + this.login + " : " + this.name + " : " + this.surname;
	}

}
