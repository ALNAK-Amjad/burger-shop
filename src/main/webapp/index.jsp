<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Burger Paradies Online Shop</title>
    <link rel="icon" type="image/x-icon" href="images/burger.jpg">
    <link rel="stylesheet" href="./CSS/global-style.css">
    <link rel="stylesheet" href="./CSS/index.css">
    <link rel="stylesheet" href="./CSS/footer.css">
</head>
<body>
<%@ include file="header.jsp" %>
<main class="main-page-body flex-col">
    <div class="grid-container">
        <div class="order-tile">
            <div class="image-container-order">
                <form action="OrderController" method="post">
                    <button type="submit" class="cut-out-text" name="filterButton" value="AllProducts">Bestellen</button>
                </form>
            </div>
        </div>
        <div class="login-profile-tile">
            <div>
                <%-- Check if a User is logged in and display the appropriate button --%>
                <c:set var="loggedUser" value="${user}" />
                <c:choose>
                    <c:when test="${empty loggedUser}">
                        <form action="login.jsp" method="post">
                            <button type="submit" class="cut-out-text-log" name="einloggen">Einloggen</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="profile.jsp" method="post">
                            <button type="submit" class="cut-out-text-log" name="profile">Mein Profil</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    <div class="grid-container">
        <div class="open-tile">
            <table class="opening-hours-table">
<<<<<<< Updated upstream
                <tr> <th>Öffnungszeiten</th></tr>
                <tr id="Montag" >
                    <td class="days">Montag</td>
                    <td class="hours">09:00-18:00</td>
                </tr>
                <tr id="Dienstag" >
                    <td class="days">Dienstag</td>
                    <td class="hours">09:00-18:00</td>
                </tr>
                <tr id="Mittwoch" >
                    <td class="days">Mittwoch</td>
                    <td class="hours">09:00-18:00</td>
                </tr>
                <tr id="Donnerstag">
                    <td class="days">Donnerstag</td>
                    <td class="hours">09:00-20:00</td>
                </tr>
                <tr id="Freitag" >
                    <td class="days">Freitag</td>
                    <td class="hours">09:00-18:00</td>
                </tr>
                <tr id="Samstag">
                    <td class="days">Samstag</td>
                    <td class="hours">10:00-18:00</td>
                </tr>
                <tr id="Sonntag" >
                    <td class="days">Sonntag</td>
                    <td class="hours">11:00-16:00</td>
=======
                <tr id="Montag" >
                    <td>Montag</td>
                    <td>09:00</td>
                    <td>-</td>
                    <td>18:00</td>
                </tr>
                <tr id="Dienstag" >
                    <td>Dienstag</td>
                    <td>09:00</td>
                    <td>-</td>
                    <td>18:00</td>
                </tr>
                <tr id="Mittwoch" >
                    <td>Mittwoch</td>
                    <td>09:00</td>
                    <td>-</td>
                    <td >18:00</td>
                </tr>
                <tr id="Donnerstag">
                    <td>Donnerstag</td>
                    <td>09:00</td>
                    <td>-</td>
                    <td>20:00</td>
                </tr>
                <tr id="Freitag" >
                    <td>Freitag</td>
                    <td>09:00</td>
                    <td>-</td>
                    <td>18:00</td>
                </tr>
                <tr id="Samstag">
                    <td>Samstag</td>
                    <td>10:00</td>
                    <td>-</td>
                    <td>18:00</td>
                </tr>
                <tr id="Sonntag" >
                    <td>Sonntag</td>
                    <td >11:00</td>
                    <td>-</td>
                    <td >16:00</td>
>>>>>>> Stashed changes
                </tr>
            </table>
        </div>
        <div class="conditional-order-tile">
            <div class="slideshow-container">

                <div class="mySlides fade">

                    <div class="image-container">
                        <form action="OrderController" method="post">
                            <button type="submit" class="cut-out-text"name="filterButton" value="VeggieBurgers">VEGGIE</button>
                        </form>
                    </div>

                </div>

                <div class="mySlides fade">

                    <div class="image-container">
                        <form action="OrderController" method="post">
                            <button type="submit" class="cut-out-text" name="filterButton" value="BeefBurgers">BEEF</button>
                        </form>
                    </div>

                </div>

                <div class="mySlides fade">

                    <div class="image-container">
                        <form action="OrderController" method="post">
                            <button type="submit" class="cut-out-text" name="filterButton" value="ChickenBurgers">CHICKEN</button>
                        </form>
                    </div>

                </div>

            </div>
        </div>
    </div>
</main>
<%@ include file="footer.jsp" %>
</body>
</html>

<script>
    let slideIndex = 0;
    showSlides();

    function showSlides() {
        let i;
        let slides = document.getElementsByClassName("mySlides");

        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }

        slideIndex++;

        if (slideIndex > slides.length) {
            slideIndex = 1
        }

        slides[slideIndex-1].style.display = "block";

        // Bild ändert sich alle 4 Sekunden
        setTimeout(showSlides, 4000);
    }
</script>
