package edu.ucam.internal.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ucam.internal.user.User;

@WebServlet("/api/public/login")
public class LoginRest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginRest() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
		User usuario = new User(request.getParameter("user"), request.getParameter("password"));

		System.out.println(usuario);
		if (usuario.check()) {
			session.setAttribute(AuthService.IS_LOGGED_IN, true);
			session.setAttribute(AuthService.LOGGED_USER_INFO, usuario);
			request.getRequestDispatcher("/app/private/main.jsp").forward(request, response);
		} else {
			session.removeAttribute(AuthService.IS_LOGGED_IN);
			session.removeAttribute(AuthService.LOGGED_USER_INFO);
			request.getRequestDispatcher("/app/public/login-error.jsp").forward(request, response);
		}
	}

}
