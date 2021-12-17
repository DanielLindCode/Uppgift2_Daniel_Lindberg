package controller;

import model.userBean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.actionBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("mySession") != null) {

			userBean bean = (userBean) request.getSession().getAttribute("mySession");

			if (request.getParameter("number") != null && request.getParameter("number") != "") {

				bean.setUserNumber(request.getParameter("number"));
			}

			HttpSession session = request.getSession();

			session.setAttribute("mySession", "user");
			request.setAttribute("mySession", "user");

			RequestDispatcher rd = request.getRequestDispatcher("userPage.jsp");
			rd.forward(request, response);

		} else {
		
			RequestDispatcher rd = request.getRequestDispatcher("logOutServlet");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		/*
		 * String user1Name = "Daniel"; String user1Password = "admin";
		 * 
		 * String user2Name = "Peter"; String user2Password = "fisk";
		 */
		actionBean ab = new actionBean();

		if (ab.findUser(username) == -1) {

			// System.out.println(username);

			HttpSession userSession = request.getSession();

			userSession.setAttribute("mySession", "user");

			userSession.setMaxInactiveInterval(3600);

			RequestDispatcher rd = request.getRequestDispatcher("userPage.jsp");
			rd.forward(request, response);

		} else {

			response.sendRedirect("index.jsp");
		}

	}
}
