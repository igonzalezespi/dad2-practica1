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
@WebServlet("/api/private/crop/views/crop-edit")
public class CropEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CropService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CropEdit() {
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
				request.getSession(false).setAttribute("element", CropService.findOne(Integer.parseInt(request.getParameter("id"))));
			} else {
				request.getSession(false).removeAttribute("element");
			}
			request.getRequestDispatcher("/app/private/crop/crop-edit.jsp").forward(request, response);
		} catch(Error e) {
			e.printStackTrace();
			request.getRequestDispatcher("/app/public/error-general.jsp").forward(request, response);
		}
	}
}
