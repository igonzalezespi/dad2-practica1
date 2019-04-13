package edu.ucam.internal.user.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.user.UserService;

@WebServlet("/api/private/user/actions/remove")
public class UserRemove extends HttpServlet {
	UserService service;
	private static final long serialVersionUID = 1L;

	public UserRemove() {
		super();
	}
	
	public void init() throws ServletException {
		service = new UserService(this.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service.remove(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath() + "/api/private/user/views/user-search");
	}
}
