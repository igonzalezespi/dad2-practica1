package edu.ucam.internal.crop.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.crop.CropService;

@WebServlet("/api/private/crop/actions/remove")
public class CropRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CropRemove() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CropService.remove(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect(request.getContextPath() + "/api/private/crop/views/crop-search");
	}
}
