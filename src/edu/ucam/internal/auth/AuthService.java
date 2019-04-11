package edu.ucam.internal.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.ucam.internal.user.User;

public class AuthService {
	public static final String IS_LOGGED_IN = "LOGGED_IN";
	public static final String LOGGED_USER_INFO = "LOGGED_USER_INFO";
	public static final String IS_ADMIN = "IS_ADMIN";

	public AuthService() {
	}

	public static boolean isLoggedIn(HttpSession session) {
		if (session != null) {
			Object isLoggedIn = session.getAttribute(IS_LOGGED_IN);
			return isLoggedIn == null ? false : (boolean) isLoggedIn;
		}
		return false;
	}

	public static boolean isAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			Object isAdmin = session.getAttribute(IS_ADMIN);
			return isAdmin == null ? false : (boolean) isAdmin;
		}
		return false;
	}

	public static void setSessionInfo(HttpSession session, boolean logIn, User user) {
		if (logIn) {
			session.setAttribute(IS_LOGGED_IN, true);
			session.setAttribute(LOGGED_USER_INFO, user);
			session.setAttribute(IS_ADMIN, user.getName().equals("admin") && user.getPassword().equals("admin"));
		} else {
			cleanSession(session);
		}
	}

	public static void cleanSession(HttpSession session) {
		if (session != null) {
			session.removeAttribute(IS_LOGGED_IN);
			session.removeAttribute(LOGGED_USER_INFO);
			session.removeAttribute(IS_ADMIN);
			session.invalidate();
		}
	}

}
