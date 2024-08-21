<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Mitarbeiter</title>
    <link rel="icon" type="image/x-icon" href="./images/burger.jpg">
    <link rel="stylesheet" href="./CSS/global-style.css">
    <link rel="stylesheet" href="./CSS/employee.css">
</head>
<body>
<%@ include file="header.jsp" %>

<main class="main-page-body flex-row">
    <%-- Get the completeOrderList attribute from application scope --%>
    <c:set var="orderList" value="${applicationScope.completeOrderList}" scope="application"/>

    <%-- List of all orders --%>
    <div class="order-list flex-col">
        <%-- Order list header --%>
        <h1 class="order-list-header default-font">Bestellungen</h1>

        <%-- Display all orders --%>
        <c:forEach items="${orderList}" var="order">

            <%-- Single order list element --%>
            <div class="m-order-tile">
                <p class="order-id default-font">Bestellnummer: ${order.getId()}</p>

                <%-- Button to show order item details --%>
                <form class="order-detail-button-container" action="EmployeeController" method="post">
                    <button class="order-detail-button" type="submit" name="orderDetail" value="${order.getId()}">Bestelldetails anzeigen</button>
                </form>

                <%-- Setting order status-text --%>
                <p>Status:
                    <c:choose>
                        <c:when test="${order.getOrderStatus() eq 1}">
                            <c:out value="Bestellung erhalten"> </c:out>
                        </c:when>
                        <c:when test="${order.getOrderStatus() eq 2}">
                            <c:out value="In Zubereitung"> </c:out>
                        </c:when>
                        <c:when test="${order.getOrderStatus() eq 3}">
                            <c:out value="Wird Geliefert"> </c:out>
                        </c:when>
                        <c:when test="${order.getOrderStatus() eq 4}">
                            <c:out value="Ausgeliefert"> </c:out>
                        </c:when>
                        <c:otherwise>Error</c:otherwise>
                    </c:choose>
                </p>

                <button class="status-button">Status Ändern</button>

                <%-- The save-button and selection is disabled until you press the change-status-button the preselected option is the momentary value.
                    the save-button submits to the EmployeeController with the parameters orderId and statusChange which are the order id for the order and its new value --%>
                <form action="EmployeeController" method="post">
                    <select class="status-select" disabled>
                        <option value="Bestellung erhalten" <c:choose><c:when
                                test="${order.getOrderStatus() eq 1}"> selected</c:when></c:choose> >
                            Bestellung erhalten
                        </option>
                        <option value="In Zubereitung" <c:choose><c:when
                                test="${order.getOrderStatus() eq 2}"> selected</c:when></c:choose> >
                            In Zubereitung
                        </option>
                        <option value="Wird Geliefert" <c:choose><c:when
                                test="${order.getOrderStatus() eq 3}"> selected</c:when></c:choose> >
                            Wird Geliefert
                        </option>
                        <option value="Ausgeliefert" <c:choose><c:when
                                test="${order.getOrderStatus() eq 4}"> selected</c:when></c:choose> >
                            Ausgeliefert
                        </option>
                    </select>
                    <input type="hidden" name="orderId" value="${order.getId()}">
                    <button class="save-button" type="submit" name="statusChange" disabled>Save</button>
                </form>
            </div>
        </c:forEach>
    </div>

    <%-- Order Details --%>
    <div class="order-detail flex-col">
        <%-- Order details header --%>
        <h1 class="order-detail-header default-font">Bestelldetails</h1>
        <c:if test="${not empty orderDetail}">
            <%-- General Information --%>
            <div class="order-detail-container flex-col">
                <p class="default-font">Bestellnummer: ${orderDetail.getId()}</p>
                <p class="default-font">Besteller Benutzer-ID: ${orderDetail.getUserId()}</p>
                <p class="default-font">Bestellstatus-ID: ${orderDetail.getOrderStatus()}</p>
                <p class="default-font">Bestellstatus: ${orderDetail.getOrderStatusString()}</p>
                <p class="default-font">
                    Gesamtwert:
                    <%-- Format the double to German price --%>
                    <fmt:formatNumber value="${orderDetail.getTotalPrice()}" pattern="#0.00" var="totalPrice" />
                    <span class="order-total-price">${totalPrice}€</span>
                </p>
                
                <%-- Delivery Address --%>
                <h2 class="order-detail-address-header default-font">Lieferadresse</h2>
                <p class="default-font">Vorname: ${orderDetail.getFirstname()}</p>
                <p class="default-font">Nachname: ${orderDetail.getLastname()}</p>
                <p class="default-font">Straße: ${orderDetail.getStreet()}</p>
                <p class="default-font">Hausnummer: ${orderDetail.getHousenumber()}</p>
                <p class="default-font">Adresszusatz: ${orderDetail.getAddressSupplement()}</p>
                <p class="default-font">Ort: ${orderDetail.getCity()}</p>
                <p class="default-font">PLZ: ${orderDetail.getZipcode()}</p>
                <p class="default-font">Telefonnummer: ${orderDetail.getPhone()}</p>
            </div>

            <%-- Information on ordered items --%>
            <h2 class="order-detail-items-header default-font">Bestellte Produkte</h2>
            <div class="order-detail-items flex-col">
                <c:forEach items="${orderDetail.getOrderedItems()}" var="orderItems">
                    <div class="order-item flex-col">
                        <%-- Product name and price --%>
                        <div class="order-item-info-container flex-row">
                            <p class="order-item-name default-font">${orderItems.getName()}</p>
                            <fmt:formatNumber value="${orderItems.getPrice()}" pattern="#0.00" var="productPrice" />
                            <p class="order-item-price default-font">${productPrice}€</p>
                        </div>
                        <%-- Product options --%>
                        <div class="order-item-options-container flex-col">
                            <%-- Display all selected options of the item --%>
                            <c:forEach items="${orderItems.getOptions()}" var="option">
                                <div class="order-item-option-info-container flex-row">
                                    <p class="order-item-option-name default-font">${option.key}</p>
                                    <fmt:formatNumber value="${option.value}" pattern="#0.00" var="optionPrice" />
                                    <p class="order-item-option-price default-font">${optionPrice}€</p>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</main>
<%@ include file="footer.jsp" %>
</body>
</html>

<script>
  // adds eventlistener to m-order-tile
  document.addEventListener('DOMContentLoaded', function () {
    var orderTiles = document.querySelectorAll('.m-order-tile');
    //adds eventlistener to the status-button, save-button and status-select for every m-order-tile
    orderTiles.forEach(function (tile) {
      var statusButton = tile.querySelector('.status-button');
      var saveButton = tile.querySelector('.save-button');
      var statusSelect = tile.querySelector('.status-select');

      //adds function when click to status-button that enables the selection and save-button
      statusButton.addEventListener('click', function () {
        statusSelect.disabled = !statusSelect.disabled;
        saveButton.disabled = !saveButton.disabled;
      });

      // adds function when click to save-button that dynamically sets the value of the save-button
      // trying to disable the button here overwrites the submit event from the button which causes the post-method not to be called
      saveButton.addEventListener('click', function () {
        var selectedOption = statusSelect.value;
        saveButton.value = selectedOption;
      });
    });
  });
</script>
