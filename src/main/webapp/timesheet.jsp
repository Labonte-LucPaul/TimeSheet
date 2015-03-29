<%@page import="model.User"%>
<%@page import="core.db.tables.Tables" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Time Sheet</title>
</head>
<body>
<%
User user = null;
if(session.getAttribute(Tables.USERS.toString()) == null) {
    response.sendRedirect("login.jsp");
    return;
} else {
  user = (User)session.getAttribute(Tables.USERS.toString());
}
%>
    <form action="/logout" method="post">
    <input type="submit" value="Logout"/>
    </form>
    <p>Welcome <%=user.getFirstName() %> <%=user.getLastname() %></p>
</body>
</html>