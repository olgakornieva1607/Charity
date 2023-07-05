<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/user/header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Zmień hasło</h1>
    </div>

    <c:if test="${not empty error}">
        <div style="color: red">${error}</div>
    </c:if>
    <c:if test="${not empty success}">
        <div style="color: green">${success}</div>
    </c:if>

    <div class="card shadow mb-4"/>
    <div class="card-body"/>
    <div class="container-fluid>

            <div class="card shadow mb-4" >
    <div class="card-body">
        <form:form method="post" action="${pageContext.request.contextPath}/user/change-password">

            <div class="form-group">
                <input type="password" name="currentPassword" required placeholder="Bieżące hasło">
            </div>

            <div class="form-group">
                <input type="password" name="newPassword" required placeholder="Nowe hasło">
            </div>

            <div>
                <input class="btn btn-primary" type="submit" value="Zmień hasło">
            </div>
        </form:form>
    </div>

    </body>
</html>