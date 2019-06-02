package edu.ucam.internal.crop.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.crop.CropService;

/**
 * Servlet implementation class CropSearch
 */
@WebServlet("/api/private/crop/views/crop-search")
public class CropSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CropService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CropSearch() {
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getSession(false).setAttribute("list", CropService.findAll());
			request.getRequestDispatcher("/app/private/crop/crop-search.jsp").forward(request, response);
		} catch(Error e) {
			e.printStackTrace();
			request.getRequestDispatcher("/app/public/error-general.jsp").forward(request, response);
		}
	}
}
