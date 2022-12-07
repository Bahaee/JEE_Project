package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bean.LoginBean;
import dao.LoginDAO;




@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    private LoginDAO loginDao;

    public void init() {
        loginDao = new LoginDAO();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        LoginBean loginBean = new LoginBean();
	        loginBean.setUsername(username);
	        loginBean.setPassword(password);

	        try {
	            if (loginDao.validate(loginBean)) {
	                HttpSession session = request.getSession();
	                session.setAttribute("username",username);
	                response.sendRedirect("list");
	            } else {
	                HttpSession session = request.getSession();
	                session.setAttribute("user", username);
	                response.sendRedirect("login.jsp");
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
