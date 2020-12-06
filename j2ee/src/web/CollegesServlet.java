package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import utils.BookmarksUtil;
import utils.CollegesUtil;
import db.CollegesDAO;

@WebServlet("/colleges")
public class CollegesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static CollegesDAO collegesDao;

	public void init() {
		collegesDao = new CollegesDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = (String) request.getSession(false).getAttribute("email");
		System.out.println("EMAIL ID from Sessions Storage: "+username);
		
		CollegesUtil collegesUtil  = new CollegesUtil();
		collegesUtil.setUsername(username);

		try {
			if (collegesDao.validate(collegesUtil)) {
				response.setStatus(200);
				JSONArray college = collegesDao.clgJSON;
				//JSONArray examBookmarks = bookmarksDao.examJSON;
				request.setAttribute("college",college.toString());
				//request.setAttribute("examBookmarks",examBookmarks.toString());
				request.getRequestDispatcher("colleges.jsp").forward(request, response);
			} else {
				response.setStatus(401);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String univid = request.getParameter("uid");
		String username = (String) request.getSession(false).getAttribute("email");
		System.out.println("passed:"+univid);
		CollegesUtil collegesUtil  = new CollegesUtil();
		collegesUtil.setuid(univid);
		collegesUtil.setUsername(username);

		try {
			if (collegesDao.validate(collegesUtil)) {
				response.setStatus(200);
				JSONArray collegeBookmarks = collegesDao.collegeJSON;
				JSONArray examBookmarks = collegesDao.examJSON;
				request.setAttribute("collegeBookmarks",collegeBookmarks.toString());
				request.setAttribute("examBookmarks",examBookmarks.toString());
				request.getRequestDispatcher("bookmarks.jsp").forward(request, response);
			} else {
				request.setAttribute("error","true");
				request.getRequestDispatcher("colleges.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}