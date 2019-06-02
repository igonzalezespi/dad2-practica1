package edu.ucam.internal.user.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.user.User;
import edu.ucam.internal.user.UserService;

@WebServlet("/api/private/user/actions/insert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInsert() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(UserService.getNextId(), request.getParameter("login"), request.getParameter("name"), request.getParameter("surname"));
		UserService.insert(user.getId(), user);
		response.sendRedirect(request.getContextPath() + "/api/private/user/views/user-search");
	}
}
