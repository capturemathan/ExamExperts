package web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.LoginUtil;
import db.LoginDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDao;

	public void init() {
		loginDao = new LoginDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("email");
		String password = request.getParameter("pass");
		LoginUtil loginUtil = new LoginUtil();
		loginUtil.setUsername(username);
		loginUtil.setPassword(password);

		try {
			if (loginDao.validate(loginUtil)) {
				HttpSession session = request.getSession();
				session.setAttribute("email",username);
				response.setStatus(200);
				response.sendRedirect("dashboard.jsp");
			} else {
				request.setAttribute("error","true");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}