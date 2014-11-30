<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Time Sheet - Initialize projects</title>

<link rel="stylesheet" type="text/css" href="../css/table/table-default.css"/>

<script type="text/javascript" src="../js/table-projects.js"></script>
</head>
<body>

<table class="editable" id="projects">
<tr><th>Project Name</th><th>Description</th><th>Weekley Time</th></tr>
<tr>
    <td><input type="text" id="projectName" placeholder="Project Name"/></td>
    <td><input type="text" id="projectDescription" placeholder="Project Description"/></td>
    <td><input type="text" id="weekleyTime" placeholder="Weekley Time (ex: 37.5)"/></td>
    <td><a href="javascript:addRow('projects')"><img alt="add" src="../img/default/24x24/add_24x24.png"></a></td>
</tr>
</table>

</body>
</html>