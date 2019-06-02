package edu.ucam.internal.farm.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.crop.CropService;
import edu.ucam.internal.farm.FarmService;

/**
 * Servlet implementation class FarmSearch
 */
@WebServlet("/api/private/farm/views/farm-edit")
public class FarmEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FarmService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FarmEdit() {
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getSession(false).setAttribute("crops", CropService.findAll());
			if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
				request.getSession(false).setAttribute("element", FarmService.findOne(Integer.parseInt(request.getParameter("id"))));
			} else {
				request.getSession(false).removeAttribute("element");
			}
			request.getRequestDispatcher("/app/private/farm/farm-edit.jsp").forward(request, response);
		} catch(Error e) {
			e.printStackTrace();
			request.getRequestDispatcher("/app/public/error-general.jsp").forward(request, response);
		}
	}
}
