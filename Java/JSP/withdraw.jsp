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
<form method = "POST" action ="withdraw.jsp">
<input type="number" name = "amt" placeholder = "Amount"></input>
<input type="submit" name = "sub">
</form>
<%
if(request.getParameter("sub")!=null) {
	int amt = Integer.parseInt(request.getParameter("amt"));
	int id = Integer.parseInt(session.getAttribute("id").toString());
	try {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/1ms19cs016";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
		PreparedStatement ps;
		ResultSet rs = null;
		Statement st = con.createStatement();
		con.setAutoCommit(false);
		String query2 = "select balance from bank where id = "+id;
		Savepoint sp = con.setSavepoint();
		ps = con.prepareStatement(query2);
		rs=ps.executeQuery();
		int balance1=0;
		while(rs.next()) {
			balance1 = rs.getInt(1);
		}
		balance1 -= amt;
		//out.println(balance1);
		String query3 = "update bank set balance = "+balance1+" where id = "+id;
		ps= con.prepareStatement(query3);
		ps.executeUpdate();
		if(balance1<0) {
			out.println("Unsucc...\nTry again");
			con.rollback(sp);
		}
		else {
		con.releaseSavepoint(sp);
		con.commit();
		out.println("Succ...");
		response.sendRedirect("index.jsp");
		}
}catch(Exception e)
	{
	  e.printStackTrace();
	}
}
%>
</body>
</html>