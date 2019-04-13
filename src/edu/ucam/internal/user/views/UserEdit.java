package edu.ucam.internal.user.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.internal.user.UserService;

/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/api/private/user/views/user-edit")
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEdit() {
        super();
    }
	
	public void init() throws ServletException {
		service = new UserService(this.getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
				request.getSession(false).setAttribute("element", service.findOne(Integer.parseInt(request.getParameter("id"))));
			} else {
				request.getSession(false).removeAttribute("element");
			}
			request.getRequestDispatcher("/app/private/user/user-edit.jsp").forward(request, response);
		} catch(Error e) {
			e.printStackTrace();
			request.getRequestDispatcher("/app/public/error-general.jsp").forward(request, response);
		}
	}
}
