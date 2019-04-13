package edu.ucam.internal.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/public/login")
public class LoginRest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginRest() {
        super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Auth auth = new Auth(request.getParameter("user"), request.getParameter("password"));

		if (auth.check(this.getServletContext())) {
			AuthService.setSessionInfo(request.getSession(true), true, auth);
			request.getRequestDispatcher("/app/private/main.jsp").forward(request, response);
		} else {
			AuthService.cleanSession(request.getSession(false));
			request.getRequestDispatcher("/app/public/login-error.jsp").forward(request, response);
		}
	}

}
