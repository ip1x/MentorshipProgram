<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Users</title>
</head>
<body>
<c:choose>
    <c:when test="${users != null}">
        <h1>Users</h1>

        <a href="/users/add">Add</a>
        <table style="border: 1px solid; width: 500px; text-align:center">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Level</th>
                <th>Primary Skill</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <c:url var="editUrl" value="/users/edit/${user.id}" />
                <c:url var="deleteUrl" value="/users/delete/${user.id}" />
                <tr>
                    <td align="left"><c:out value="${user.id}" /></td>
                    <td align="left"><c:out value="${user.name}" /></td>
                    <td align="left"><c:out value="${user.email}" /></td>
                    <td align="left"><c:out value="${user.level}" /></td>
                    <td align="left"><c:out value="${user.primarySkill}" /></td>
                    <td align="left"><a href="${editUrl}">Edit</a></td>
                    <td align="left"><form:form modelAttribute="user" method="POST" action="${deleteUrl}"><input type="submit" value="Delete" /></form:form></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:when test="${user != null}">
        <h1>User</h1>

        <a href="/users/get/all">View all users</a>
        <table style="border: 1px solid; width: 500px; text-align:center">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Level</th>
                <th>Primary Skill</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
                <c:url var="editUrl" value="/users/edit/${user.id}" />
                <c:url var="deleteUrl" value="/users/delete/${user.id}" />
                <tr>
                    <td align="left"><c:out value="${user.id}" /></td>
                    <td align="left"><c:out value="${user.name}" /></td>
                    <td align="left"><c:out value="${user.email}" /></td>
                    <td align="left"><c:out value="${user.level}" /></td>
                    <td align="left"><c:out value="${user.primarySkill}" /></td>
                    <td align="left"><a href="${editUrl}">Edit</a></td>
                    <td align="left"><form:form modelAttribute="user" method="POST" action="${deleteUrl}"><input type="submit" value="Delete" /></form:form></td>
                </tr>
            </tbody>
        </table>
    </c:when>
</c:choose>
</body>
</html>
