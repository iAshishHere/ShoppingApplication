package com.shoppingapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingapp.pojos.UserDetails;
import com.shoppingapp.services.UserService;

/**
 * Servlet implementation class UserLoginServelet
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		if(request.getParameter("doLogin") != null) {
			
			UserDetails userDetails = new UserDetails(request.getParameter("UserName"), request.getParameter("Password"));
			UserService checkValidate = new UserService();

			boolean validation = checkValidate.doValidation(userDetails);
			
			if (validation) {
				HttpSession session = request.getSession();
				session.setAttribute("name", request.getParameter("UserName"));
				request.getRequestDispatcher("Product").forward(request, response);
			} else {
				request.setAttribute("message", "Login failed! Try again");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
			
		}
		
		if(request.getParameter("doLogout") != null) {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
		}
		
	}

}
