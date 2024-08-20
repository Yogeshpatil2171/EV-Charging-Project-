package registerStationPortal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class stationRegister
 */
public class stationRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stationRegister() {
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
		doGet(request, response);
		Connection con = Dbconnectionportal.Dbconnection.connect();
		   int Id=0;
		   System.out.println("heyyy");
		     try {
		         String Sname = request.getParameter("Sname");
		         String Address = request.getParameter("Address");
		         String city= request.getParameter("city");
		         String Taluka = request.getParameter("Taluka");
		         String District = request.getParameter("District");
		         String Mobile = request.getParameter("Mobile");
		         double Latitude = Double.parseDouble(request.getParameter("Latitude"));
		         double Longitude = Double.parseDouble(request.getParameter("Longitude"));
		         String Password= request.getParameter("Password");
		         int Power = Integer.parseInt(request.getParameter("Power"));
		         double OpenTime = Double.parseDouble(request.getParameter("OpenTime"));
		         double closeTime = Double.parseDouble(request.getParameter("closeTime"));
		         System.out.println("firstName");
		         PreparedStatement pstmt = con.prepareStatement("insert into user_register values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		         pstmt.setInt(1, Id);
		         pstmt.setString(2, Sname);
		         pstmt.setString(3, Address);
		         pstmt.setString(4, city);
		         pstmt.setString(5, Taluka);
		         pstmt.setString(6, District);
		         pstmt.setString(7, Mobile);
		         pstmt.setFloat(8, (float) Latitude);
		         pstmt.setFloat(9, (int) Longitude);
		         pstmt.setString(10, Password);
		         pstmt.setInt(11, Power);
		         pstmt.setFloat(12, (float) OpenTime);
		         pstmt.setFloat(13, (int) closeTime);
		         pstmt.setString(14, "Pending");
		        
		         System.out.println("heyyy");
		         

		         int rowsInserted = pstmt.executeUpdate();

		         if (rowsInserted > 0) {
		             response.sendRedirect("addForm.html");
//		             System.out.println("Insert successful!");
		         } else {
		             response.sendRedirect("register.html");
		         }

		     } catch (SQLException  e) {
		         e.printStackTrace();  // Log the exception details or provide a meaningful message to the user.
		         // You might want to redirect the user to an error page.
		         
		     } 
		     System.out.println("heyyy");
	}

}
