<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>${user.username},欢迎您</h1>

<input type="button" value="我的借阅" id="mine"><br>
<hr>
<form action="/ConferenceRoom/selectByDateServlet" method="post">
    日期：<input id="borrowDate" name="borrowDate"><input type="hidden" name="userid" value="${user.id}"><input type="submit" class="button" value="查询">
</form>

<script>
    document.getElementById("mine").onclick = function (){
        location.href = "/ConferenceRoom/selectByUserServlet?userid=${user.id}";
    }
</script>
</body>
</html>
