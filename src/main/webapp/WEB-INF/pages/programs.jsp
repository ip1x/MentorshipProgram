<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Programs</title>
</head>
<body>
<c:choose>
    <c:when test="${programs != null}">
        <h1>Programs</h1>

        <a href="/programs/add">Add</a>
        <table style="border: 1px solid; width: 500px; text-align:center">
            <thead>
            <tr>
                <th align="left">ID</th>
                <th align="left">Name</th>
                <th align="left">Office location</th>
                <th align="left">Start date</th>
                <th align="left">End date</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${programs}" var="program">
                <c:url var="editUrl" value="/programs/edit/${program.id}" />
                <c:url var="deleteUrl" value="/programs/delete/${program.id}" />
                <tr>
                    <td align="left"><c:out value="${program.id}" /></td>
                    <td align="left"><c:out value="${program.name}" /></td>
                    <td align="left"><c:out value="${program.officeLocation}" /></td>
                    <td align="left"><c:out value="${program.startDate}" /></td>
                    <td align="left"><c:out value="${program.endDate}" /></td>
                    <td align="left"><a href="${editUrl}">Edit</a></td>
                    <td align="left"><form:form method="POST" action="${deleteUrl}"><input type="submit" value="Delete" /></form:form></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:when test="${program != null}">
        <h1>Program</h1>

        <a href="/programs/get/all">View all programs</a>
        <table style="border: 1px solid; width: 500px; text-align:center">
            <thead>
            <tr>
                <th align="left">ID</th>
                <th align="left">Name</th>
                <th align="left">Office location</th>
                <th colspan="2"></th>
            </tr>
            </thead>
            <tbody>
                <c:url var="editUrl" value="/programs/edit/${program.id}" />
                <c:url var="deleteUrl" value="/programs/delete/${program.id}" />
                <tr>
                    <td align="left"><c:out value="${program.id}" /></td>
                    <td align="left"><c:out value="${program.name}" /></td>
                    <td align="left"><c:out value="${program.officeLocation}" /></td>
                    <td align="left"><a href="${editUrl}">Edit</a></td>
                    <td align="left"><form:form method="POST" action="${deleteUrl}"><input type="submit" value="Delete" /></form:form></td>
                </tr>
        </table>
    </c:when>
</c:choose>
</body>
</html>
