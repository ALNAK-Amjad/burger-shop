<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrieren</title>
    <link rel="icon" type="image/x-icon" href="./images/burger.jpg">
    <link rel="stylesheet" href="CSS/register.css">
    <link rel="stylesheet" href="CSS/global-style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<main class="main-page-body flex-col">
    <%-- Submission form for the Register page --%>
    <form id="register-form" class="form-container default-form-container flex-col" action="RegisterController" method="post">
        <%-- Register Header Text --%>
        <div class="register-header-container">
            <h2 class="register-header-text default-font">Registrierung</h2>
        </div>

        <%-- Both input field containers --%>
        <div class="register-data-container flex-row">
            <%-- Form fields for Account Data --%>
            <div class="register-account-data-container flex-col">
                <%-- Account Data Header Text --%>
                <div class="register-sub-header-container">
                    <h3 class="register-sub-header-text default-font">Benutzerdaten</h3>
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
                    <input class="form-field-input default-text-input-field" id="password" type="password" name="password" placeholder="Passwort" required/>
                </div>
                <%-- Form field for Password Repeat --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/password-icon.png" alt="Passwort Logo" draggable="false"/>
                        <p class="label-text default-font">Passwort Wiederholen</p>
                    </div>
                    <input class="form-field-input default-text-input-field" id="password-repeat" type="password" name="password-repeat" placeholder="Passwort Wiederholen" required/>
                </div>
                <%-- Form field for E-Mail --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/email-icon.png" alt="E-Mail Logo" draggable="false"/>
                        <p class="label-text default-font">E-Mail</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="email" name="email" placeholder="E-Mail" required/>
                </div>
                <%-- Form field for Phonenumber --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/phone-icon.png" alt="Telefon Logo" draggable="false"/>
                        <p class="label-text default-font">Telefonnummer</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="tel" name="phonenumber" placeholder="Telefonnummer" required/>
                </div>
            </div>

            <%-- Form fields for Address Data --%>
            <div class="register-address-data-container flex-col">
                <%-- Address Data Header Text --%>
                <div class="register-sub-header-container">
                    <h3 class="register-sub-header-text default-font">Anschrift</h3>
                </div>
                <%-- Form field for Firstname --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/user-icon.png" alt="Benutzer Logo" draggable="false"/>
                        <p class="label-text default-font">Vorname</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="text" name="firstname" placeholder="Vorname" required/>
                </div>
                <%-- Form field for Lastname --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/user-icon.png" alt="Benutzer Logo" draggable="false"/>
                        <p class="label-text default-font">Nachname</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="text" name="lastname" placeholder="Nachname" required/>
                </div>
                <%-- Form field for Street --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/home-icon.png" alt="Haus Logo" draggable="false"/>
                        <p class="label-text default-font">Straße</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="text" name="street" placeholder="Straße" required/>
                </div>
                <%-- Form field for Housenumber --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/housenumber-icon.png" alt="Hausnummer Logo" draggable="false"/>
                        <p class="label-text default-font">Hausnummer</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="text" name="housenumber" placeholder="Hausnummer" required/>
                </div>
                <%-- Form field for Address Supplement --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/address-supplement-icon.png" alt="Adresszusatz Logo" draggable="false"/>
                        <p class="label-text default-font">Adresszusatz</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="text" name="addressSupplement" placeholder="Adresszusatz"/>
                </div>
                <%-- Form field for Zipcode --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/zipcode-icon.png" alt="PLZ Logo" draggable="false"/>
                        <p class="label-text default-font">PLZ</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="text" minlength="5" maxlength="5" name="zipcode" placeholder="PLZ" required/>
                </div>
                <%-- Form field for City --%>
                <div class="form-field flex-row">
                    <div class="form-field-label flex-row">
                        <img class="label-icon" src="images/city-icon.png" alt="Ort Logo" draggable="false"/>
                        <p class="label-text default-font">Ort</p>
                    </div>
                    <input class="form-field-input default-text-input-field" type="text" name="city" placeholder="Ort" required/>
                </div>
            </div>
        </div>

        <%-- Existing Account Notice --%>
        <div class="no-account-text-container flex-row">
            <p class="default-font">Sie haben schon ein Konto?</p>
            <a class="login-forward-link default-link default-font" href="login.jsp">Hier Einloggen</a>
        </div>

        <%-- Register Button --%>
        <div class="form-button-container flex-row">
            <button class="register-button default-button-secondary" type="submit" name="register">Registrieren</button>
        </div>
    </form>
</main>

<%-- Check password and password-repeat values --%>
<script>
    document.getElementById("register-form").addEventListener("submit", function (event) {
        let pass = document.getElementById("password");
        let passRepeat = document.getElementById("password-repeat");
        if (pass.value !== passRepeat.value) {
            event.preventDefault();
            alert("Die Passwörter stimmen nicht überein!");
        }
    });
</script>
<%@ include file="footer.jsp" %>
</body>
</html>
