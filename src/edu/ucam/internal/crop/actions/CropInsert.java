package edu.ucam.internal.crop.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.crop.Crop;
import edu.ucam.internal.crop.CropService;

@WebServlet("/api/private/crop/actions/insert")
public class CropInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CropInsert() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Crop crop = new Crop(CropService.getNextId(), request.getParameter("name"), Integer.parseInt(request.getParameter("size")));
		CropService.insert(crop.getId(), crop);
		response.sendRedirect(request.getContextPath() + "/api/private/crop/views/crop-search");
	}
}
