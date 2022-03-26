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
<form method = "POST" action ="create.jsp">
<input type="number" name = "id" placeholder = "ID"></input>
<input type="text" name = "name" placeholder = "Name"></input>
<input type="number" name = "bal" placeholder = "Balance"></input>
<input type="submit" name = "sub">
</form>
<%
if(request.getParameter("sub")!=null) {
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int bal = Integer.parseInt(request.getParameter("bal"));
	try {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/1ms19cs016";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
		PreparedStatement ps;
		ResultSet rs = null;
		Statement st = con.createStatement();
		con.setAutoCommit(false);
		String query = "insert into bank(id,name,balance) values(?,?,?)";
		ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setInt(3, bal);
		ps.execute();
		con.commit();
		response.sendRedirect("index.jsp");
}catch(Exception e)
	{
	  e.printStackTrace();
	}
}
%>
</body>
</html>