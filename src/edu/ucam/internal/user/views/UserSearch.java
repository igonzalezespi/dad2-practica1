package edu.ucam.internal.user.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ucam.internal.user.UserService;

/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/api/private/user/views/user-search")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearch() {
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
			request.getSession(false).setAttribute("list", service.findAll());
			request.getRequestDispatcher("/app/private/user/user-search.jsp").forward(request, response);
		} catch(Error e) {
			e.printStackTrace();
			request.getRequestDispatcher("/app/public/error-general.jsp").forward(request, response);
		}
	}
}
