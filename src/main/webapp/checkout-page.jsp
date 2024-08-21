<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Checkout Seite</title>
    <link rel="icon" type="image/x-icon" href="./images/burger.jpg">
    <link rel="stylesheet" href="./CSS/global-style.css">
    <link rel="stylesheet" href="./CSS/checkout-page.css">
</head>
<body>
    <%-- generic header for all pages --%>
    <%@ include file="header.jsp" %>

    <%-- main body of the checkout page --%>
    <main class="main-page-body flex-row">
        <%-- order form container including address entry form and payment method form --%>
        <form class="order-form default-form-container flex-col" onsubmit="submitForm(event)">
            <%-- Order Data Header Text --%>
            <div class="order-header-container">
                <h2 class="order-header-text default-font">Bestelldaten</h2>
            </div>

            <%-- form for address data --%>
            <div class="address-form flex-col">
                <h3 class="order-sub-header-text default-font">Lieferadresse</h3>
                
                <%-- Get the data of the logged in user (if exists) and prefills the form if data exists --%>
                <c:set var="loggedUser" value="${user}" />

                <%-- Form input fields --%>
                <div class="form-field flex-row">
                    <label class="label-text default-font" for="firstname">Vorname:</label>
                    <input class="form-input-text default-text-input-field" type="text" id="firstname" name="firstname" placeholder="Vorname" value="${loggedUser.getFirstname()}" required>
                </div>
                <div class="form-field flex-row">
                    <label class="label-text default-font" for="lastname">Nachname:</label>
                    <input class="form-input-text default-text-input-field" type="text" id="lastname" name="lastname" placeholder="Nachname" value="${loggedUser.getLastname()}" required>
                </div>
                <div class="form-field flex-row">
                    <label class="label-text default-font" for="street">Straße:</label>
                    <input class="form-input-text default-text-input-field" type="text" id="street" name="street" placeholder="Straße" value="${loggedUser.getStreet()}" required>
                </div>
                <div class="form-field flex-row">
                    <label class="label-text default-font" for="housenumber">Hausnummer:</label>
                    <input class="form-input-text default-text-input-field" type="text" id="housenumber" name="housenumber" placeholder="Hausnummer" value="${loggedUser.getHouseNumber()}" required>
                </div>
                <div class="form-field flex-row">
                    <label class="label-text default-font" for="addressSupplement">Adresszusatz:</label>
                    <input class="form-input-text default-text-input-field" type="text" id="addressSupplement" name="addressSupplement" placeholder="Adresszusatz" value="${loggedUser.getAddressSupplement()}">
                </div>
                <div class="form-field flex-row">
                    <label class="label-text default-font" for="city">Ort:</label>
                    <input class="form-input-text default-text-input-field" type="text" id="city" name="city" placeholder="Ort" value="${loggedUser.getCity()}" required>
                </div>
                <div class="form-field flex-row">
                    <label class="label-text default-font" for="zipcode">Postleitzahl:</label>
                    <input class="form-input-text default-text-input-field" type="text" id="zipcode" name="zipcode" placeholder="Postleitzahl" value="${loggedUser.getZipcode()}" required>
                </div>
                <div class="form-field flex-row">
                    <label class="label-text default-font" for="phone">Telefonnummer:</label>
                    <input class="form-input-text default-text-input-field" type="text" id="phone" name="phone" placeholder="Telefonnummer" value="${loggedUser.getPhoneNumber()}">
                </div>
            </div>

            <%-- Form for the preferred payment method --%>
            <div class="payment-method-form flex-col">
                <h3 class="order-sub-header-text default-font">Zahlungsweise wählen</h3>

                <div class="form-field-container flex-row">
                    <div class="form-field">
                        <input class="form-input-radio" type="radio" id="creditCard" name="paymentMethod" value="creditCard" required>
                        <label class="label-text default-font" for="creditCard">Kreditkarte</label>
                    </div>
                    <div class="form-field">
                        <input class="form-input-radio" type="radio" id="paypal" name="paymentMethod" value="paypal">
                        <label class="label-text default-font" for="paypal">PayPal</label>
                    </div>
                    <div class="form-field">
                        <input class="form-input-radio" type="radio" id="bankTransfer" name="paymentMethod" value="bankTransfer">
                        <label class="label-text default-font" for="bankTransfer">Banküberweisung</label>
                    </div>
                </div>
            </div>
 
            <button type="submit" class="checkout-submit-button default-button-secondary">Bestellung abschließen</button>
        </form>

        <%-- Summary of all items to be ordered --%>
        <div class="shopping-cart flex-col">
            <%-- Shopping Cart Header Text --%>
            <div class="cart-header-container">
                <h2 class="cart-header-text default-font">Warenkorb</h2>
            </div>

            <%-- Container for cart items --%>
            <div class="cart-item-container flex-col">
                <%-- Display all cart items --%>
                <c:forEach items="${orderedItems}" var="product">
                    <div class="cart-item flex-col">
                        <%-- Product name and price --%>
                        <div class="cart-item-info-container flex-row">
                            <p class="cart-item-name default-font">${product.getName()}</p>
                            <fmt:formatNumber value="${product.getPrice()}" pattern="#0.00" var="productPrice" />
                            <p class="cart-item-price default-font">${productPrice}€</p>
                        </div>
                        <%-- Product options --%>
                        <div class="cart-item-options-container flex-col">
                            <%-- Display all selected options of the item --%>
                            <c:forEach items="${product.getOptions()}" var="option">
                                <div class="cart-item-option-info-container flex-row">
                                    <p class="cart-item-option-name default-font">${option.key}</p>
                                    <fmt:formatNumber value="${option.value}" pattern="#0.00" var="optionPrice" />
                                    <p class="cart-item-option-price default-font">${optionPrice}€</p>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <%-- Display and calculate the total price --%>
            <div class="cart-total-price-container">
                <c:set var="totalPrice" value="0.00" />
                <c:set var="roundedTotalPrice" value="0.00" />

                <%-- Iterate through all items in the cart --%>
                <c:forEach items="${orderedItems}" var="product">
                    <%-- Get the product price and add it to the total --%>
                    <c:set var="productPrice" value="${product.getPrice()}" />
                    <c:set var="totalPrice" value="${totalPrice + productPrice}" />
                    <%-- Iterate through all options of the product  --%>
                    <c:forEach items="${product.getOptions()}" var="options">
                        <%-- Get the option price and add it to the total --%>
                        <c:set var="optionPrice" value="${options.value}" />
                        <c:set var="totalPrice" value="${totalPrice + optionPrice}" />
                    </c:forEach>
                    <fmt:formatNumber value="${totalPrice}" pattern="#0.00" var="roundedTotalPrice" />
                </c:forEach>

                <p class="cart-total-price default-font">Gesamtwert: ${roundedTotalPrice}€</p>
            </div>
        </div>
    </main>
    
    <%-- generic footer for all pages --%>
    <%@ include file="footer.jsp" %>
</body>
</html>

<!-- Include jQuery library -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function submitForm(event) {
    // Prevent default form submit behaviour
    event.preventDefault();

    // Get form data
    let formData = {};
    $(".order-form input").each(function() {
        formData[this.name] = $(this).val();
    });

    // Convert form data to JSON
    let jsonData = JSON.stringify(formData);

    // Get the base context path
    let contextPath = '<%= request.getContextPath() %>';
    let backendUrl = contextPath + '/CheckoutController';

    // Send JSON data to the backend
    fetch(backendUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: jsonData,
    })
    .then((response) => {
        // Handle success response
        if (response.ok) {
            window.location.href = '<%= request.getContextPath() %>/profile.jsp';
        } else {
            // Handle error response
            console.error('Request failed:', response.status, response.statusText);
        }
    })
    .catch((error) => {
        // Handle fetch error
        console.error('Fetch error:', error);
    });
}
</script>
