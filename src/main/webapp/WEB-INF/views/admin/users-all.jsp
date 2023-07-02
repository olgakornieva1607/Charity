<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="/WEB-INF/views/admin/header.jsp" %>
<html>

<!-- Begin Page Content -->
<div class="container-fluid">

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">Lista użytkowników</h5>
        </div>
        <div class="card-body">

            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td><c:out value="${user.id}"/></td>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.surname}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:forEach items="${user.roles}" var="role">${role} </c:forEach></td>
                            <td><c:if test="${user.enabled > 0}">Aktywny</c:if>
                                <c:if test="${user.enabled < 1}">Nieaktywny</c:if></td>
                            <td>
                                <a href="<c:out value="/admin/user/edit/${user.id}"/>">Edytuj</a>
                                <a href="<c:out value="/admin/user/disable/${user.id}"/>">Zablokuj</a>
                                <a href="<c:out value="/admin/user/delete/${user.id}"/>">Usuń</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
<!-- /.container-fluid -->
</div>
</div>
<!-- End of Main Content -->
</body>
</html>
