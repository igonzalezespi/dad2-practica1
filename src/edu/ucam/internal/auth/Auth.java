package edu.ucam.internal.auth;

import javax.servlet.ServletContext;

import edu.ucam.internal.user.User;
import edu.ucam.internal.user.UserService;

public class Auth {

	private String login;
	private String password;

	public Auth(String login, String password) {
		this.setLogin(login);
		this.setPassword(password);
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
	
	public boolean check(ServletContext context) {
		if (this.login.equals("admin") && this.password.equals("admin")) {
			return true;
		}
		User user = UserService.findByLogin(this.login);
		return user != null && this.login.equals(this.password);
	}
	
	public String toString() {
		return this.login + " : " + this.password;
	}

}
