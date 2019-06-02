package edu.ucam.internal.farm.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.farm.FarmService;

/**
 * Servlet implementation class FarmSearch
 */
@WebServlet("/api/private/farm/views/farm-search")
public class FarmSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	FarmService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FarmSearch() {
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getSession(false).setAttribute("list", FarmService.findAll());
			request.getRequestDispatcher("/app/private/farm/farm-search.jsp").forward(request, response);
		} catch(Error e) {
			e.printStackTrace();
			request.getRequestDispatcher("/app/public/error-general.jsp").forward(request, response);
		}
	}
}
