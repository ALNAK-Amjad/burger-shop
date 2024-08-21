<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Bestellseite</title>
    <link rel="icon" type="image/x-icon" href="./images/burger.jpg" >
    <link rel="stylesheet" href="./CSS/global-style.css">
    <link rel="stylesheet" href="./CSS/order-page.css">
</head>
<body>
    <%@ include file="header.jsp" %>

    <%-- Main body of the order page --%>
    <main class="main-page-body flex-col">
        <%-- Menubar with filters for product groups --%>
        <form class="product-group-bar flex-row" action="OrderController" method="post">
            <button class="product-filter-button default-button-primary" type="submit" name="filterButton" value="AllProducts">Alle Produkte</button>
            <button class="product-filter-button default-button-primary" type="submit" name="filterButton" value="BeefBurgers">Beef Burger</button>
            <button class="product-filter-button default-button-primary" type="submit" name="filterButton" value="ChickenBurgers">Chicken Burger</button>
            <button class="product-filter-button default-button-primary" type="submit" name="filterButton" value="VeggieBurgers">Veggie Burger</button>
            <button class="product-filter-button default-button-primary" type="submit" name="filterButton" value="Extras">Extras</button>
            <button class="product-filter-button default-button-primary" type="submit" name="filterButton" value="Drinks">Drinks</button>
        </form>

        <%-- Main frame with the product list and shopping cart --%>
        <div class="order-frame flex-row">
            <%-- list of products that can be ordered --%>
            <div id="order-list" class="flex-row">
                <%-- Display the product list using JSTL --%>
                <c:forEach items="${productList}" var="product">
                    <form class="product-item-container flex-col" action="OrderController" method="post">
                        <%-- product name --%>
                        <p class="product-name default-font">${product.getName()}</p>

                        <%-- Format the double to German price --%>
                        <fmt:formatNumber value="${product.getPrice()}" pattern="#0.00" var="price" />
                        <p class="product-price default-font">${price}€</p>

                        <%-- Selectable Options to add a product to the shopping cart --%>
                        <div class="product-item-options flex-col">
                            <c:forEach var="options" items="${product.getOptions()}">
                                <%-- Format the double to German price --%>
                                <fmt:formatNumber value="${options.value}" pattern="#0.00" var="optionPrice" />
                                <%-- Checkbox with options --%>
                                <div class="product-order-checkbox-container flex-row">
                                    <input class="product-order-checkbox" type="checkbox" name="selectedOptions" value="${options.key}" />
                                    <label class="default-font" for="checkbox${options.key}">${options.key} ${optionPrice}€</label>
                                </div>
                            </c:forEach>
                        </div>

                        <%-- Button to add a product to the shopping cart --%>
                        <button class="product-order-button default-button-primary" type="submit" name="addProduct" value="${product.getId()}">Hinzufügen</button>
                    </form>
                </c:forEach>
            </div>

            <%-- current products in the shopping cart --%>
            <div class="shopping-cart flex-col">
                <h1 class="shopping-cart-header default-font">Warenkorb</h1>

                <%-- Display the items in the cart as a list --%>
                <div class="shopping-cart-list">
                    <c:forEach items="${shoppingCart}" var="addedProduct" varStatus="loop">
                        <%-- Format the double to German price --%>
                        <fmt:formatNumber value="${addedProduct.getPrice()}" pattern="#0.00" var="price" />

                        <%-- Display a single item --%>
                        <form class="shopping-cart-item flex-col" action="OrderController" method="post">
                            <%-- Main information including product name and price + delete button --%>
                            <div class="shopping-cart-item-main-info flex-row">
                                <%-- information on the item --%>
                                <p class="product-cart-text default-font">${addedProduct.getName()}</p>
                                <p class="product-cart-text product-cart-price default-font">${price}€</p>

                                <%-- button to remove items --%>
                                <input type="hidden" name="productId" value="${product.getId()}">
                                <input type="hidden" name="index" value="${loop.index}">
                                <button class="cart-delete-button" type="submit" name="shoppingCartButton" value="delete"></button>
                            </div>

                            <%-- Info about added options of the product --%>
                            <div class="shopping-cart-item-options flex-col">
                                <%-- Selected options of the item --%>
                                <c:forEach var="selectedOptions" items="${addedProduct.getOptions()}">
                                    <%-- Format the double to German price --%>
                                    <fmt:formatNumber value="${selectedOptions.value}" pattern="#0.00" var="optionPriceCart" />
                                    <%-- Display the option and the price --%>
                                    <p class="product-cart-text product-cart-option-text default-font">${selectedOptions.key} ${optionPriceCart}€</p>
                                </c:forEach>
                            </div>
                        </form>
                    </c:forEach>
                </div>

                <%-- Display and calculate the total price --%>
                <div class="shopping-cart-total-price">
                    <c:set var="totalPrice" value="0.00" />
                    <c:set var="roundedTotalPrice" value="0.00" />

                    <%-- Iterate through all items in the cart --%>
                    <c:forEach items="${shoppingCart}" var="product">
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

                    <p class="default-font">Gesamtwert: ${roundedTotalPrice}€</p>
                </div>

                <div class="shopping-cart-button-container flex-row">
                    <%-- Disable the buttons if the shopping cart is empty --%>
                    <c:choose>
                        <c:when test="${empty shoppingCart}">
                            <button type="submit" class="cart-submit-button default-button-primary" disabled>Jetzt Bestellen</button>
                            <button type="submit" class="cart-delete-all-button default-button-primary" disabled>Warenkorb leeren</button>
                        </c:when>
                        <c:otherwise>
                            <%-- Submit Button to place an order --%>
                            <form action="OrderController" method="post">
                                <%-- Hidden input field to tell the backend that this is an order submission --%>
                                <input type="hidden" name="orderSubmitted" value="regularShoppingCart">
                                <button type="submit" class="cart-submit-button default-button-primary">Jetzt Bestellen</button>
                            </form>

                            <%-- Delete Button to delete all items inside the cart --%>
                            <form action="OrderController" method="post">
                                <%-- Hidden input field to tell the backend that the cart delete button has been clicked --%>
                                <input type="hidden" name="deleteAllCartItems" value="deleteCart">
                                <button type="submit" class="cart-delete-all-button default-button-primary">Warenkorb leeren</button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </main>
    
    <%@ include file="footer.jsp" %>
</body>
</html>
