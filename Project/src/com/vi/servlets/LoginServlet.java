package com.vi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vi.db.DBHelper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String uname= request.getParameter("uname");
		String pword= request.getParameter("pword");
		
		DBHelper db = new DBHelper();
		int status = db.getLoginStatus(uname,pword);
		if(status==1) {
			RequestDispatcher rd = request.getRequestDispatcher("page1.jsp");
			rd.forward(request, response);
		}else if(status==-1) {
			pw.println("<html><h3>user not found</h3></html>");
		}else if(status==-2) {
			pw.println("<html><h3>password did not match</h3></html>");
		}else {
			pw.println("<html><h3>invalid login</h3></html>");
		}
		
	}

}
