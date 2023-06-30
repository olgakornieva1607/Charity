<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/admin/header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Edytuj fundację</h1>
    </div>

    <div class="card shadow mb-4"/>
    <div class="card-body"/>

    <div class="container-fluid>

                <div class="card shadow mb-4">
    <div class="card-body">

        <form:form action="/admin/institution/edit" method="post" modelAttribute="institutionToEdit">

            <form:input type="hidden" name="id" path="id" id="id" />

            <label for="name">Nazwa</label>
            <form:input class="form-control" path="name" id="name" maxlength="50"/><br>
            <form:errors path="name" cssClass="error" style="color: red; font-size: smaller;"/><br>

            <label for="description">Opis</label>
            <form:textarea class="form-control" path="description" id="description" maxlength="100"/><br>
            <form:errors path="description" cssClass="error" style="color: red; font-size: smaller;"/><br>

            <input class="btn btn-primary" type="submit" value="Edytuj">

        </form:form>

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
