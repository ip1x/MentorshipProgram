<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Programs</title>
</head>
<body>
<h1>Create New Program</h1>
<c:url var="saveUrl" value="/programs/add" />
<form:form commandName="program" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td align="left"><form:label path="name">Name:</form:label></td>
            <td align="left"><form:input path="name"/></td>
            <td align="left"><form:errors path="name" cssClass="error"/></td>
        </tr>

        <tr>
            <td align="left"><form:label path="officeLocation">Office location</form:label></td>
            <td align="left"><form:input path="officeLocation"/></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form:form>

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
        <c:url var="addUserUrl" value="/programs/add/user/${user.id}" />
        <c:url var="deleteUserUrl" value="/users/delete/user/${user.id}" />
        <tr>
            <td align="left"><c:out value="${user.id}" /></td>
            <td align="left"><c:out value="${user.name}" /></td>
            <td align="left"><c:out value="${user.email}" /></td>
            <td align="left"><c:out value="${user.level}" /></td>
            <td align="left"><c:out value="${user.primarySkill}" /></td>
            <td align="left"><form:form method="POST" action="${addUserUrl}"><input type="submit" value="Delete" /></form:form></td>
            <td align="left"><form:form method="POST" action="${deleteUserUrl}"><input type="submit" value="Delete" /></form:form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
