<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="icon" type="image/x-icon" href="images/burger.jpg" >
    <link rel="stylesheet" href="./CSS/profile.css">
</head>
<body>

<%-- Generic header for all pages --%>
<%@ include file="header.jsp" %>

<%-- Main frame --%>
<div class="container-profile">
    <%-- Check if a User is logged in --%>
    <c:set var="loggedUser" value="${user}" />
    <c:choose>
        <c:when test="${empty loggedUser}">
            <%-- Redirect to the login page if no user is logged in --%>
            <% response.sendRedirect("login.jsp"); %>
        </c:when>
        <c:otherwise>
            <%-- Profile information about the user --%>
            <table class="profile-data">
                <tr>
                    <th class="login-registrierung" colspan="2">Mein Profil</th>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/user-icon.png" alt="User Icon"/><b>Benutzername:</b></td>
                    <td>${user.getUsername()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/user-icon.png" alt="User Icon"/><b>Name:</b></td>
                    <td>${user.getLastname()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/user-icon.png" alt="User Icon"/><b>Vorname:</b></td>
                    <td>${user.getFirstname()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/email-icon.png" alt="E-Mail Icon"/><b>E-Mail:</b></td>
                    <td>${user.getEmail()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/phone-icon.png" alt="Telefon Icon"/><b>Telefonnummer:</b></td>
                    <td>${user.getPhoneNumber()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/home-icon.png" alt="Haus Icon"/><b>Straße:</b></td>
                    <td>${user.getStreet()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/housenumber-icon.png" alt="Hausnummer Icon"/><b>Hausnummer:</b></td>
                    <td>${user.getHouseNumber()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/address-supplement-icon.png" alt="Adresszusatz Icon"/><b>Adresszusatz:</b></td>
                    <td>${user.getAddressSupplement()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/zipcode-icon.png" alt="PLZ Icon"/><b>PLZ:</b></td>
                    <td>${user.getZipcode()}</td>
                </tr>
                <tr>
                    <td><img width="19" height="19" src="images/city-icon.png" alt="Ort Icon"/><b>Ort:</b></td>
                    <td>${user.getCity()}</td>
                </tr>
            </table>

            <div class="order-list-profile-page">
            <%-- Order list --%>
            <div class="order-list">
                <h2>Bestellungen</h2>
                <c:forEach items="${user.getOrderList()}" var="order">
                    <div class="single-order-container">
                        <p class="general-text">
                            Bestellnummer:
                            <span>${order.getId()}</span>
                        </p>
                        <p class="general-text">
                            Bestellstatus:
                            <span class="order-status-number">${order.getOrderStatus()}</span>
                            <span class="order-status-text">${order.getOrderStatusString()}</span>
                        </p>
                        <p class="general-text">
                            Gesamtwert:
                            <%-- Format the double to German price --%>
                            <fmt:formatNumber value="${order.getTotalPrice()}" pattern="#0.00" var="totalPrice" />
                            <span class="order-total-price">${totalPrice}€</span>
                        </p>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
