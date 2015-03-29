<%@page import="model.User" %>
<%@page import="core.db.tables.Tables" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Time Sheet - Login</title>
</head>
<body>
<%
User user = null;
if(session.getAttribute(Tables.USERS.toString()) != null) {
    response.sendRedirect("timesheet.jsp");
    return;
}
%>
    <div>
        <p>Login<p>
        <form action="/login" method="POST">
            <input type="text" name="login" required="required" placeholder="Login"/><br>
            <input type="password" name="passwd" required="required" placeholder="Password"/><br>
            <input type="submit" title="Login"/>
        </form>
    </div>
</body>
</html>