<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title></title>
</head>
<body>
<h1>Users</h1>

<a href="/welcome">Go on home page</a>
<br/>
<a href="/users/get/all">View all users</a>
<table style="border: 1px solid; width: 500px; text-align:center">
    <thead>
    <tr>
        <th align="left">ID</th>
        <th align="left">Name</th>
        <th align="left">Email</th>
        <th align="left">Level</th>
        <th align="left">Primary Skill</th>
        <th colspan="2"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td align="left"><c:out value="${user.id}"/></td>
            <td align="left"><c:out value="${user.name}"/></td>
            <td align="left"><c:out value="${user.email}"/></td>
            <td align="left"><c:out value="${user.level}"/></td>
            <td align="left"><c:out value="${user.primarySkill}"/></td>
            <td align="left"><a href="${editUrl}">Edit</a></td>
            <td>
                <button type="button" onclick="RestDelete('${deleteUrl}')">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
