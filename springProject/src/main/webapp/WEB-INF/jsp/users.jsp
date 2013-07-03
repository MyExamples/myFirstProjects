<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<table>
<c:forEach items="${users}" var="u">
    <tr>
        <td><c:out value="${u.name}"/></td>
        <td><c:out value="${u.email}"/></td>
        <td><c:out value="${u.birth}"/></td>
        <td><a href='<c:url value="user/${u.id}/edit"/>'>Edit</a></td>
        <td><a href='<c:url value="user/${u.id}/delete"/>'>Delete</a></td>
    </tr>
</c:forEach>
</table>

<form:form modelAttribute="user">
        <form:hidden path="id"/>
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/><form:errors path="name" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email"/><form:errors path="email" /></td>
        </tr>
        <tr>
            <td>Birth</td>
            <td><form:input path="birth"/><form:errors path="birth" /></td>    
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</form:form>