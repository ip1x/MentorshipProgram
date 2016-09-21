<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Users</title>
</head>
<body>
    <h1>Create New User</h1>
    <c:url var="saveUrl" value="/users/add" />
    <form:form commandName="user" method="POST" action="${saveUrl}">
        <table>
            <tr>
                <td align="left"><form:label path="name">Name:</form:label></td>
                <td align="left"><form:input path="name"/></td>
                <td align="left"><form:errors path="name" cssClass="error"/></td>
            </tr>

            <tr>
                <td align="left"><form:label path="email">Email</form:label></td>
                <td align="left"><form:input path="email"/></td>
                <td align="left"><form:errors path="email" cssClass="error"/></td>
            </tr>

            <tr>
                <td align="left"><form:label path="level">Level</form:label></td>
                <td align="left">
                    <form:select path="level">
                        <form:options items="${levelOptions}" />
                    </form:select>
                </td>
            </tr>

            <tr>
                <td align="left"><form:label path="primarySkill">Primary skill</form:label></td>
                <td align="left"><form:input path="primarySkill"/></td>
            </tr>
        </table>

        <input type="submit" value="Save" />
    </form:form>
</body>
</html>
