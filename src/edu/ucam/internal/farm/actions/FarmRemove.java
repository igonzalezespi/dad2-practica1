package edu.ucam.internal.farm.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.farm.FarmService;

@WebServlet("/api/private/farm/actions/remove")
public class FarmRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FarmRemove() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FarmService.remove(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath() + "/api/private/farm/views/farm-search");
	}
}
