<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="Dbconnectionportal.Dbconnection"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Charging stations by city</title>
</head>
<body>
<center>
<h1><b>Charging stations by city </b></h1>
<%
	String district = request.getParameter("City");
	
		Connection con = Dbconnection.connect();
	
		try{
		
		 	PreparedStatement pstmt =con.prepareStatement("select * from user_register where City=?");
		 	ResultSet rs=pstmt.executeQuery();
		 	
		 	%>
		<h1>Approve Charge Station</h1>

		<table border="2">
		<tr>
		<th>Id</th>
		<th>Station Name</th>
		<th>Address</th>
		<th>City</th>
		<th>Taluka</th>
		<th>District</th>
		<th>Mobile No.</th>
		<th>Latitude</th>
		<th>Lognitude Time</th>
		<th>password</th>
		<th>Power</th>
		<th>Open Time</th>
		<th>Close Time</th>
		<th>Status</th>
		<th>Action</th>


		</tr>
		<%while(rs.next()){ %>

		<TR>
		<TD> <%=rs.getInt(1) %></TD>
		<TD> <%=rs.getString(2) %></TD>
		<TD> <%=rs.getString(3) %></TD> 
		<TD> <%=rs.getString(4) %></TD>
		<TD> <%=rs.getString(5) %></TD>
		<TD> <%=rs.getString(6) %></TD>
		<TD> <%=rs.getString(7) %></TD>
		<TD> <%=rs.getString(8) %></TD>
		<TD> <%=rs.getString(9) %></TD>
		<TD> <%=rs.getString(10) %></TD>
		<TD> <%=rs.getString(11) %></TD>
		<TD> <%=rs.getString(12) %></TD>
		<TD> <%=rs.getInt(13) %></TD>

		<Td> <a href="UserTable.Approval.jsp?id=<%=rs.getString(1)%>">approve</a></Td>
		<Td> <a href="delete.jsp?id=<%=rs.getString(1)%>">delete</a></Td>
		<tr>
		<%}
		} catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </center>
</body>
</html>