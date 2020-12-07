package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

import utils.ExamsUtil;
import db.ExamsDAO;

@WebServlet("/exams")
public class ExamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ExamsDAO examsDao;

	public void init() {
		examsDao = new ExamsDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = (String) request.getSession(false).getAttribute("email");
		System.out.println("EMAIL ID from Sessions Storage: "+username);
		
		ExamsUtil examsUtil  = new ExamsUtil();
		examsUtil.setUsername(username);

		try {
			if (examsDao.validate(examsUtil)) {
				response.setStatus(200);
				
				JSONArray exams = ExamsDAO.exJSON;
				request.setAttribute("exams",exams.toString());
				request.getRequestDispatcher("exams.jsp").forward(request, response);
			} else {
				response.setStatus(401);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String examid = request.getParameter("eid");
		String username = (String) request.getSession(false).getAttribute("email");
		ExamsUtil examsUtil  = new ExamsUtil();
		examsUtil.seteid(examid);
		examsUtil.setUsername(username);

		try {
			if (examsDao.validate(examsUtil)) {
				response.setStatus(200);
				JSONArray collegeBookmarks = examsDao.collegeJSON;
				JSONArray examBookmarks = examsDao.examJSON;
				request.setAttribute("collegeBookmarks",collegeBookmarks.toString());
				request.setAttribute("examBookmarks",examBookmarks.toString());
				request.getRequestDispatcher("bookmarks.jsp").forward(request, response);
			} else {
				request.setAttribute("error","true");
				request.getRequestDispatcher("exams.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}