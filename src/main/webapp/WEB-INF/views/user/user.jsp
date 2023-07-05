<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="/WEB-INF/views/user/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary"></h5>
        </div>
        <div class="card-body">

            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <th>Email</th>
                    </tr>
                    <tr>
                        <td><sec:authentication property="principal.user.name"/></td>
                        <td><sec:authentication property="principal.user.surname"/></td>
                        <td><sec:authentication property="principal.user.email"/></td>
                        <td><a href="<c:out value="/user/edit"/>">Edytuj</a></td>
                        <td><a href="<c:out value="/user/change-password"/>">Zmień hasło</a></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</html>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<%@include file="/WEB-INF/views/admin/footer.jsp" %>
