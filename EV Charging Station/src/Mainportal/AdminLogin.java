package Mainportal;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnectionportal.Dbconnection;


/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("heyyy");
		Connection con = Dbconnection.connect();
		String username=request.getParameter("email");
		String password=request.getParameter("password");
		
		System.out.println("username : "+username);
		System.out.println("Password : "+password);
		System.out.println("heyyy");
		if(username.equals("sagar2003@gmail.com") && password.equals("admin"))
		{
			response.sendRedirect("ViewTable.jsp");
		}
		else{
			response.sendRedirect("index.html");
		}
		doGet(request, response);
	}

}
