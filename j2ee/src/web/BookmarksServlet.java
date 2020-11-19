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
import db.BookmarksDAO;

@WebServlet("/bookmarks")
public class BookmarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookmarksDAO bookmarksDao;

	public void init() {
		bookmarksDao = new BookmarksDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = (String) request.getSession(false).getAttribute("email");
		System.out.println("EMAIL ID from Sessions Storage: "+username);
		
		BookmarksUtil bookmarksUtil  = new BookmarksUtil();
		bookmarksUtil.setUsername(username);

		try {
			if (bookmarksDao.validate(bookmarksUtil)) {
				response.setStatus(200);
				JSONArray collegeBookmarks = bookmarksDao.collegeJSON;
				JSONArray examBookmarks = bookmarksDao.examJSON;
				request.setAttribute("collegeBookmarks",collegeBookmarks.toString());
				request.setAttribute("examBookmarks",examBookmarks.toString());
				request.getRequestDispatcher("bookmarks.jsp").forward(request, response);
			} else {
				response.setStatus(401);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}