<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./CSS/global-style.css">
    <link rel="stylesheet" href="./CSS/header.css">
</head>
<header class="header-panel flex-row">
    <%-- Clickable logo and text --%>
    <a class="header-logo-container flex-row" href="index.jsp">
        <img class="header-logo" src="images/burger.jpg" alt="Burger Logo" draggable="false">
        <p class="header-text">Burger Paradies</p>
    </a>

    <%-- Navigation Bar inside the header --%>
    <nav class="header-nav flex-row">
        <a class="header-nav-item nav-homepage" href="index.jsp">Startseite</a>
        <div class="nav-item-separator"></div>
        <a class="header-nav-item nav-order" href="order-page.jsp">Bestellen</a>
        <div class="nav-item-separator"></div>
        <a class="header-nav-item nav-contact" href="contact.jsp">Kontakt</a>
    </nav>

    <%-- Login and Logout Button --%>
    <div class="login-logout-button-container flex-row">
        <%-- Check if a User is logged in and display the appropriate button --%>
        <c:set var="loggedUser" value="${user}" />
        <c:choose>
            <c:when test="${empty loggedUser}">
                <form action="login.jsp" method="post">
                    <button class="login-button action-button default-button-secondary" type="submit" name="einloggen">Einloggen</button>
                </form>
                <form action="register.jsp" method="post">
                    <button class="register-button action-button default-button-secondary" type="submit" name="register">Registrieren</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="profile.jsp" method="post">
                    <button class="profile-button action-button default-button-secondary" type="submit" name="profile">Mein Profil</button>
                </form>
                <form action="LogoutController" method="post">
                    <button class="logout-button action-button default-button-secondary" type="submit" name="logout">Abmelden</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</header>
</html>
