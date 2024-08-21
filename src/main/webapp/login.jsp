<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link rel="icon" type="image/x-icon" href="images/burger.jpg" >
    <link rel="stylesheet" href="CSS/login.css">
    <link rel="stylesheet" href="CSS/global-style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<main class="main-page-body flex-col">
    <%-- Submission form for the Login page --%>
    <form class="form-container default-form-container flex-col" action="LoginController" method="post">
        <%-- Login Header Text --%>
        <div class="login-header-container">
            <h2 class="login-header-text default-font">Login</h2>
        </div>

        <%-- Form field for Username --%>
        <div class="form-field flex-row">
            <div class="form-field-label flex-row">
                <img class="label-icon" src="images/user-icon.png" alt="Benutzer Logo" draggable="false"/>
                <p class="label-text default-font">Benutzername</p>
            </div>
            <input class="form-field-input default-text-input-field" type="text" name="username" placeholder="Benutzername" required/>
        </div>

        <%-- Form field for Password --%>
        <div class="form-field flex-row">
            <div class="form-field-label flex-row">
                <img class="label-icon" src="images/password-icon.png" alt="Passwort Logo" draggable="false"/>
                <p class="label-text default-font">Passwort</p>
            </div>
            <input class="form-field-input default-text-input-field" type="password" name="password" placeholder="Passwort" required/>
        </div>
        
        <%-- Check if the error message for failed login attempt should be displayed --%>
        <c:set var="error" value="${errorMessage}" />
        <c:if test="${not empty error}">
            <p class="error-message-text default-font">${error}</p>
        </c:if>

        <%-- No Account Notice --%>
        <div class="no-account-text-container flex-row">
            <p class="default-font">Sie haben noch kein Konto?</p>
            <a class="register-forward-link default-link default-font" href="register.jsp">Jetzt Registrieren</a>
        </div>

        <%-- Login Button --%>
        <div class="form-button-container flex-row">
            <button class="login-button default-button-secondary" type="submit">Anmelden</button>
        </div>
    </form>
</main>
<%@ include file="footer.jsp" %>
</body>
</html>
