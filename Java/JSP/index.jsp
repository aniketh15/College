<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "java.sql.*" %>
<form method = "POST" action ="index.jsp">
<input type="radio" name = "n" value =1 checked>Create</input>
<input type="radio" name = "n" value =2 >Display</input>
<input type="radio" name = "n" value =3 >Transact</input>
<input type="submit" name = "sub">
</form>
<%
if(request.getParameter("sub")!=null) {
	int n = Integer.parseInt(request.getParameter("n"));
	try {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/1ms19cs016";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
		PreparedStatement ps;
		ResultSet rs = null;
		Statement st = con.createStatement();
		con.setAutoCommit(false);
		switch(n){
		case 1:
			//request.getRequestDispatcher("create.jsp").forward(request,response);
			response.sendRedirect("create.jsp");
			break;
		case 2:
			String query1 = "select * from bank";
			ps = con.prepareStatement(query1);
			rs = ps.executeQuery();
			while(rs.next()) {
				out.println("ID,Name,Balance\n"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			break;
		case 3:
			//request.getRequestDispatcher("transact.jsp").forward(request,response);
			response.sendRedirect("transact.jsp");
			break;
		}
}catch(Exception e)
	{
	  e.printStackTrace();
	}
}
%>
</body>
</html>