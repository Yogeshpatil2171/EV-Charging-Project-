package CharginglogInPortal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Charginglogin
 */
public class Charginglogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Charginglogin() {
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
		String x=request.getParameter("mobileNo");
		int mobileNo=Integer.parseInt(x);
		String password=request.getParameter("password");
		
		System.out.println("username : "+mobileNo);
		System.out.println("Password : "+password);
		
		Connection con = Dbconnectionportal.Dbconnection.connect();
		
		int i=1;
			try {
				PreparedStatement pstmt =con.prepareStatement("select * from user_register where Mobile=? and Password=?");
				pstmt.setInt(1,mobileNo);
				pstmt.setString(2, password);
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					 i=1;
					System.out.println("Valid USer");
				}
				if(i>0){
					response.sendRedirect("ChargeS_Dashboard.html");
				}else{
					response.sendRedirect("Chargingportal.html");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		doGet(request, response);
	}

}
