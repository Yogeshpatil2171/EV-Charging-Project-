package userRegisterportal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnectionportal.Dbconnection;


/**
 * Servlet implementation class userRegister
 */
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = Dbconnection.connect();
        int id = 0;
        try {
            String name = request.getParameter("Uname");
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");
            String mobile = request.getParameter("Mobile");
            String city = request.getParameter("City");

            // Check if 'City' parameter is null or empty
            if (city == null || city.isEmpty()) {
                // Handle the case where 'City' is null or empty, for example:
                // You could set a default city, or return an error message to the user
                throw new IllegalArgumentException("City cannot be null or empty");
            }

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO usertable VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.setString(5, mobile);
            pstmt.setString(6, city);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                response.sendRedirect("addForm.html");
                System.out.println("Insert successful!");
            } else {
                System.out.println("Failed to insert user.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception details or provide a meaningful message to the user.
                                  // You might want to redirect the user to an error page.
            response.sendRedirect("error.html");
        }
    } 
    }
