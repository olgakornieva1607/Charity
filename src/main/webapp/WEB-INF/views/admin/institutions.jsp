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

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <a href="<c:out value="/admin/institution/new"/>"
           class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-plus fa-sm text-white-50"></i> Dodaj fundację</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">Lista fundacji</h5>
        </div>
        <div class="card-body">

            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Nazwa</th>
                        <th>Opis</th>
                    </tr>
                    <c:forEach items="${institutions}" var="institution">
                        <tr>
                            <td><c:out value="${institution.name}"/></td>
                            <td><c:out value="${institution.description}"/></td>
                            <td>
                                <a href="<c:out value="/admin/institution/edit/${institution.id}"/>">Edytuj</a>
                                <a href="<c:out value="/admin/institution/delete/${institution.id}"/>">Usuń</a>
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

