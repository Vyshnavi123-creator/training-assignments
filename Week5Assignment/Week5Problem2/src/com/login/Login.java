package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		HttpSession session=request.getSession();
		if(uname.equals("Vyshnavi") && pass.equals("123")) {
			
			session.setAttribute("userName", uname);
			
			 response.sendRedirect("welcome.jsp");
		}
		else {
			session.setAttribute("msg","Please Login with correct credentials");
			response.sendRedirect("login.jsp");
		}
	}
}
