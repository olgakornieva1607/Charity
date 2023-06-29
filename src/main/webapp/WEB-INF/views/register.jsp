<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="loginHeader.jsp"/>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form action="/registration" method="post" modelAttribute="user">

        <div class="form-group">
            <form:input class="form-control" path="name" id="name" maxlength="20"
                        placeholder="Name"/>
            <form:errors path="name" cssClass="error" style="color: red; font-size: small;"/>
        </div>

        <div class="form-group">
            <form:input class="form-control" path="surname" id="surname" maxlength="20"
                        placeholder="Surname"/>
            <form:errors path="surname" cssClass="error" style="color: red; font-size: small;"/>
        </div>

        <div class="form-group">
            <form:input class="form-control" path="email" id="email" type="email" name="email" maxlength="30"
                        placeholder="Email"/>
            <form:errors path="email" cssClass="error" style="color: red; font-size: small;"/>
        </div>

        <div class="form-group">
            <form:password class="form-control" path="password" id="password" maxlength="20"
                           placeholder="Hasło"/>
            <form:errors path="password" cssClass="error" style="color: red; font-size: small;"/>
        </div>
        <div class="form-group">
            <form:password class="form-control" path="password2" id="password2" maxlength="20"
                           placeholder="Powtórz hasło"/>
            <form:errors path="password2" cssClass="error" style="color: red; font-size: small;"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="<c:url value="/login"/>" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>

    </form:form>

</section>

<jsp:include page="footer.jsp"/>
</body>
</html>

