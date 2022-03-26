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
<form method = "POST" action ="deposit.jsp">
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
		rs = st.executeQuery(query2);
		int bal=0;
		while(rs.next()) {
			bal = rs.getInt(1);
		}
		bal+=amt;
		String query3 = "update bank set balance = "+bal+" where id = "+id;
		ps= con.prepareStatement(query3);
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