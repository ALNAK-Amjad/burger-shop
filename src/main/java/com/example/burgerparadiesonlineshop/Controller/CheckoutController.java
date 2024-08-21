package com.example.burgerparadiesonlineshop.Controller;

import com.example.burgerparadiesonlineshop.Entity.*;
import com.example.burgerparadiesonlineshop.Model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

/**
 * @brief   Main Controller for the Checkout page
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController", "/checkout-page.jsp"})
public class CheckoutController extends HttpServlet {

    private List<Products> orderedItems = new ArrayList<>();

    /**
     * @brief   Handle Post requests from the checkout-page.jsp page
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the flag to check if a user is currently logged in
        Boolean isLoggedIn = (Boolean) request.getSession().getAttribute("loggedIn");

        // Check if a user is logged in
        if (isLoggedIn != null && isLoggedIn) {
            // Get the currently logged in user
            Users currentUser = (Users) request.getSession().getAttribute("user");
            
            // Save the order
            saveOrder(request, currentUser);

            // Set the OrderList
            request.getSession().setAttribute("userOrderList", currentUser.getOrderList());
            getServletContext().setAttribute("completeOrderList", OrderList.getOrderList());

            // Forward to the user profile page
            forwardRequestDispatcher(request, response, "profile.jsp");
        } else {
            // Save the order as for a Guest User
            saveOrder(request, null);

            // Set the OrderList
            getServletContext().setAttribute("completeOrderList", OrderList.getOrderList());

            // Forward to the user profile page
            forwardRequestDispatcher(request, response, "profile.jsp");
        }
    }

    /**
     * @brief   Retrieves the "orderedItems" attribute and saves it to this Controller
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void getOrderedItemsFromSession(HttpServletRequest request) {
        // Retrieve the data from the session scope
        Object cartItems = request.getSession().getAttribute("orderedItems");

        // Check if the received data is a List
        if (cartItems != null && cartItems instanceof List<?>) {
            orderedItems = (List<Products>) cartItems;
        }
    }

    /**
     * @brief   Save the order if a user is logged in
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void saveOrder(HttpServletRequest request, Users user) throws IOException {
        // Retrieve the JSON data from the request
        String jsonData = request.getReader().lines().collect(Collectors.joining());

        // Convert the raw JSON data to a HashMap
        HashMap<String, Object> orderFormData = convertJsonToHashMap(jsonData);

        // Get all the ordered products
        getOrderedItemsFromSession(request);

        // Create a deep copy of the product item list
        ArrayList<Products> itemsToBeSaved = new ArrayList<>();
        for (Products item : orderedItems) {
            itemsToBeSaved.add(item);
        }

        // Get the highest available Order-ID
        int newOrderId = OrderList.getAvailableId();

        // Initialize the userId which will be saved
        int userId;

        // Check if the order was placed by a registered user
        if (user != null) {
            // Get the current User ID
            userId = user.getId();
        } else {
            // Use the default if a guest user placed the order
            userId = -1;
        }

        // Create a new order instance
        Orders order = new Orders(
            newOrderId,
            userId,
            1,
            (String) orderFormData.get("firstname"),
            (String) orderFormData.get("lastname"),
            (String) orderFormData.get("street"),
            (String) orderFormData.get("housenumber"),
            (String) orderFormData.get("addressSupplement"),
            (String) orderFormData.get("city"),
            (String) orderFormData.get("zipcode"),
            (String) orderFormData.get("phone"),
            (String) orderFormData.get("paymentMethod"),
            itemsToBeSaved
        );

        // Save the order to the order list of the current user
        if (user != null) {
            user.addOrderToList(order);
        }

        // Save the order to the general order list
        OrderList.addOrderToList(order);
    }

    /**
     * @brief   Converts a given JSON to a HashMap with key value pairs
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private HashMap<String, Object> convertJsonToHashMap(String rawJsonString) {
        // Initialization
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap;
        HashMap<String, Object> jsonHashMap = new HashMap<>();

        // Parse the JSON data using Jackson
        try {
            // Convert the JSON to a Map
            jsonMap = objectMapper.readValue(rawJsonString, Map.class);
        } catch (JsonProcessingException e) {
            // Return an empty HashMap is the conversion fails
            return jsonHashMap;
        }

        // Convert the Map to a HashMap
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            jsonHashMap.put(entry.getKey(), entry.getValue());
        }

        return jsonHashMap;
    }

    /**
     * @brief   Forward the request to the given JSP page target
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void forwardRequestDispatcher(HttpServletRequest request, HttpServletResponse response, String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}