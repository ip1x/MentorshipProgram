<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Users</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    var RestDelete = function(deleteUrl) {
        $.ajax({
            type: 'DELETE',
            url:  deleteUrl,
            async: true,
            success: function(result) {
                alert("Ok");
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('Error: ' + jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
</script>

<body>
<c:choose>
    <c:when test="${users != null}">
        <h1>Users</h1>

        <a href="/users/add">Add</a>
        <table style="border: 1px solid; width: 500px; text-align:center">
            <thead>
            <tr>
                <th align="left">ID</th>
                <th align="left">Name</th>
                <th align="left">Email</th>
                <th align="left">Level</th>
                <th align="left">Primary Skill</th>
                <th align="left">Birthday</th>
                <th align="left">Create date</th>
                <th align="left">Created by</th>
                <th align="left">Modify date</th>
                <th align="left">Modified by</th>
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
                    <td align="left"><c:out value="${user.birthDay}" /></td>
                    <td align="left"><c:out value="${user.createDate}" /></td>
                    <td align="left"><c:out value="${user.createdByUserWithIp}" /></td>
                    <td align="left"><c:out value="${user.modifyDate}" /></td>
                    <td align="left"><c:out value="${user.modifiedByUserWithIp}" /></td>
                    <td align="left"><a href="${editUrl}">Edit</a></td>
                    <td><button type="button" onclick="RestDelete('${deleteUrl}')">Delete</button></td>
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
                <th align="left">ID</th>
                <th align="left">Name</th>
                <th align="left">Email</th>
                <th align="left">Level</th>
                <th align="left">Primary Skill</th>
                <th align="left">Birthday</th>
                <th align="left">Create date</th>
                <th align="left">Created by</th>
                <th align="left">Modify date</th>
                <th align="left">Modified by</th>
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
                    <td align="left"><c:out value="${user.birthDay}" /></td>
                    <td align="left"><c:out value="${user.createDate}" /></td>
                    <td align="left"><c:out value="${user.createdByUserWithIp}" /></td>
                    <td align="left"><c:out value="${user.modifyDate}" /></td>
                    <td align="left"><c:out value="${user.modifiedByUserWithIp}" /></td>
                    <td align="left"><a href="${editUrl}">Edit</a></td>
                    <td><button type="button" onclick="RestDelete(${deleteUrl})">Delete</button></td>
                </tr>
            </tbody>
        </table>
    </c:when>
</c:choose>
</body>
</html>
