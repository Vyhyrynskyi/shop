<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="resourceContext" value="${pageContext.request.contextPath}" />

<html lang="en">
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="${resourceContext}/bootstrap.min.css">
    <link rel="stylesheet" href="${resourceContext}/layout.css">
    <link rel="stylesheet" href="${resourceContext}/style.css">
    <script type="text/javascript" src="${resourceContext}/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="center">

    <form:form modelAttribute="loginForm" cssClass="search-box">
        <form:input path="login" />
        <form:input path="password" />
        <input type="submit" class="btn btn-success" value="login" />
    </form:form>
</div>
</body>
</html>