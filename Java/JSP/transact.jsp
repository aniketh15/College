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
<form method = "POST" action ="transact.jsp">
<input type="radio" name = "n" value =1 checked>Withdraw</input>
<input type="radio" name = "n" value =2 >Deposit</input>
<input type="radio" name = "n" value =3 >Display</input>
<input type="number" name = "id" placeholder = "ID"></input>
<input type="submit" name = "sub1">
</form>
<%
if(request.getParameter("sub1")!=null) {
	int n = Integer.parseInt(request.getParameter("n"));
	int id = Integer.parseInt(request.getParameter("id"));
	session.setAttribute("id", id);
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
			request.getRequestDispatcher("withdraw.jsp").forward(request,response);
			break;
		case 2:
			request.getRequestDispatcher("deposit.jsp").forward(request,response);
			break;
		case 3:
			String query4 = "select * from bank where id = "+id;
			out.println("ID,Name,Balance\n");
			st = con.createStatement();
			rs = st.executeQuery(query4);
			while(rs.next()) {
				out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
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