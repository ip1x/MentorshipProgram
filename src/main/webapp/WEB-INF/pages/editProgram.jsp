<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Programs</title>
</head>
<body>
<h1>Edit Program</h1>
<c:url var="editUrl" value="/programs/edit/${program.id}" />
<form:form commandName="program" method="POST" action="${editUrl}">@
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

</body>
</html>
