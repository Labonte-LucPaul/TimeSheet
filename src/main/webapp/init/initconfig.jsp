<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time Sheet Initial Setup Configuration</title>

<script type="text/javascript">
function autoLogin(loginBox) {
	var fName = document.getElementsByName('firstName')[0].value;
	var lName = document.getElementsByName('lastName')[0].value;
	
	var login = fName.charAt(0) + lName;
	loginBox.value = login.toLowerCase();
}
</script>
</head>
<body>

<form action="/InitConfig" method="POST">
<table>
    <tr><td><input type="text" placeholder="Your Company's Name" required="required" /></td></tr>
    <tr><td><select required="required" title="Select Data Base Manager">
        <option value="">[ Select Database Manager ]</option>
        <option value="SQLilte3">SQLite3</option>
    </select></td></tr>
    <tr><td><input type="text" name="firstName" placeholder="First Name" required="required" /></td></tr>
    <tr><td><input type="text" name="lastName" placeholder="Last Name" required="required" /></td></tr>
    <tr><td><input type="text" name="login" placeholder="Your Login" required="required" onfocus="autoLogin(this)" /></td></tr>
    <tr><td><input type="email" name="email" placeholder="e-mail" required="required" /></td></tr>
    <tr><td><input type="password" name="passwd" placeholder="root account password" required="required" /></td></tr>
    <tr><td><input type="password" placeholder="confirm root account password" required="required" /></td></tr>
    <tr><td><input type="submit" value="Initialize"/></td></tr>
</table>
</form>

</body>
</html>