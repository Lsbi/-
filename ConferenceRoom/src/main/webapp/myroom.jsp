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

<input type="button" value="返回" id="return"><br>
<hr>

<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>日期</th>
        <th>时间</th>
        <th>会议室名称</th>
        <th>会议室容量</th>
        <th>借阅状态</th>
        <th>取消借阅</th>

    </tr>


    <c:forEach items="${rooms}" var="room" varStatus="status">
        <tr align="center">
                <%--<td>${room.id}</td>--%>
            <td>${status.count}</td>
            <td>${room.borrowDate}</td>
            <td>${room.timeSlot}</td>
            <td>${room.roomName}</td>
            <td>${room.capacity}</td>
            <c:if test="${room.status >= 1}">
                <td>已借用</td>
            </c:if>
            <c:if test="${room.status == 0}">
                <td>可借用</td>
            </c:if>

            <td><a href="/ConferenceRoom/deleteByIdServlet?id=${room.id}&amp;userid=${user.id}">取消借阅</a> </td>
        </tr>

    </c:forEach>

</table>

<script>
    document.getElementById("return").onclick = function (){
        location.href = "/ConferenceRoom/personal.jsp";
    }

</script>
</body>
</html>