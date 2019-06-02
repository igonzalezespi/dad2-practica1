package edu.ucam.internal.farm.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.crop.CropService;
import edu.ucam.internal.farm.Farm;
import edu.ucam.internal.farm.FarmService;

@WebServlet("/api/private/farm/actions/insert")
public class FarmInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FarmInsert() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Farm farm = new Farm(FarmService.getNextId(), request.getParameter("name"), CropService.findAllInString(request.getParameter("crops")));
		FarmService.insert(farm.getId(), farm);
		response.sendRedirect(request.getContextPath() + "/api/private/farm/views/farm-search");
	}
}
