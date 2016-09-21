<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Users</title>
</head>
<body>
<c:choose>
    <c:when test="${mode == 'add'}">
        <h1>Create New User</h1>
        <c:url var="saveUrl" value="/users/add" />
        <form:form modelAttribute="user" method="POST" action="${saveUrl}">
            <table>
                <tr>
                    <td><form:label path="name">Name:</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>

                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>

                <tr>
                    <td><form:label path="level">Level</form:label></td>
                    <td><form:input path="level"/></td>
                </tr>

                <tr>
                    <td><form:label path="primarySkill">Primary skill</form:label></td>
                    <td><form:input path="primarySkill"/></td>
                </tr>
            </table>

            <input type="submit" value="Save" />
        </form:form>
    </c:when>
    <c:when test="${mode == 'edit'}">
        <h1>Edit User</h1>
        <c:url var="editUrl" value="/users/edit/${user.id}" />
        <form:form modelAttribute="user" method="POST" action="${editUrl}">
            <table>
                <tr>
                    <td><form:label path="name">Name:</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>

                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>

                <tr>
                    <td><form:label path="level">Level</form:label></td>
                    <td><form:input path="level"/></td>
                </tr>

                <tr>
                    <td><form:label path="primarySkill">Primary skill</form:label></td>
                    <td><form:input path="primarySkill"/></td>
                </tr>
            </table>

            <input type="submit" value="Save" />
        </form:form>
    </c:when>
    <c:otherwise>
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
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.level}" /></td>
                    <td><c:out value="${user.primarySkill}" /></td>
                    <td><a href="${editUrl}">Edit</a></td>
                    <td><form:form modelAttribute="user" method="POST" action="${deleteUrl}"><input type="submit" value="Delete" /></form:form></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
