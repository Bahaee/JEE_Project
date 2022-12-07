package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.User;
import dao.user.UserDAOImpl;

/**
 * ControllerServlet.java
 * This Servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAOImpl userDAO;

	public void init() {
		userDAO = new UserDAOImpl();
	}
	
    public UserServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.fetchAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.fetchUserById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		double phone = Double.parseDouble(request.getParameter("phone"));
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String nationality = request.getParameter("nationality");
		String nationalIdentity = request.getParameter("nationalIdentity");
		String functionality = request.getParameter("functionality");

		User newUser = new User(username, firstName, lastName, email, phone, age, gender, nationality, nationalIdentity, functionality);
		userDAO.addUser(newUser);
		response.sendRedirect("list");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		double phone = Double.parseDouble(request.getParameter("phone"));
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String nationality = request.getParameter("nationality");
		String nationalIdentity = request.getParameter("nationalIdentity");
		String functionality = request.getParameter("functionality");

		User newUser = new User(idUser, username, firstName, lastName, email, phone, age, gender, nationality, nationalIdentity, functionality);
		userDAO.updateUser(newUser);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		userDAO.deleteUser(id);
		response.sendRedirect("list");

	}
}
