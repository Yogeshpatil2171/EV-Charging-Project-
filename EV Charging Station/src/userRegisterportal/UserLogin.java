package userRegisterportal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnectionportal.Dbconnection;



/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		
		Connection con = Dbconnection.connect();
		String username=request.getParameter("Uname");
		String password=request.getParameter("upwd");
		
		System.out.println("username : "+username);
		System.out.println("Password : "+password);
		
		try {
			PreparedStatement pstmt =con.prepareStatement("select * from usertable where Email=? and Password=?");
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			
			ResultSet rs=pstmt.executeQuery();
			int i=0;
			while(rs.next()){
				i=1;
				System.out.println("Valid USer");
			}
			if(i>0){
				response.sendRedirect("addForm.html");
			}else{
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		{
			
		}
		
		doGet(request, response);
	}

}
