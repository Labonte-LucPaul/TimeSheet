<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div>
        <p>Login<p>
        <form action="/login" method="POST">
            <input type="text" required="required" placeholder="Login"/><br>
            <input type="password" required="required" placeholder="Password"/><br>
            <input type="submit" title="Login"/>
        </form>
    </div>
</body>
</html>