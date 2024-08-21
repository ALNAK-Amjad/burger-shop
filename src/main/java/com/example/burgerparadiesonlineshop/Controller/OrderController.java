package com.example.burgerparadiesonlineshop.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.burgerparadiesonlineshop.Entity.Products;
import com.example.burgerparadiesonlineshop.Model.ProductList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @brief   Main Controller for Products
 * 
 * @details Saves the complete product list and the current shopping cart
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController", "/order-page.jsp"})
public class OrderController extends HttpServlet {

    private List<Products> completeProductList = getCompleteProductListAsList();
    private List<Products> shoppingCart = new ArrayList<>();

    /**
     * @brief   Handle Get requests from the order-page.jsp page
     * 
     * @details Currently only used for initial load of the order page
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Return the data
        forwardProductList(request);

        // Reset the shopping cart
        deleteAllCartItems(request);

        // Forward the request to the JSP page
        forwardRequestDispatcher(request, response, "order-page.jsp");
    }

    /**
     * @brief   Handle Post requests from the order-page.jsp page
     * 
     * @details If the "orderSubmitted" parameter is set then it's an order submission
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Initialize the URL target for the request
        String forwardRequestTarget;

        // Get the flag which determines if the post request is an order submission
        String orderSubmission = request.getParameter("orderSubmitted");

        // Get the flag which determines if the post request was the delete button from the shopping cart
        String shoppingCartButton = request.getParameter("shoppingCartButton");

        // Check if the button to add a product to the cart was clicked
        String productId = request.getParameter("addProduct");

        // Check if a filter button to filter the product list has been clicked
        String filter = request.getParameter("filterButton");

        // Check if the button to delete all cart items have been clicked
        String deleteAllItems = request.getParameter("deleteAllCartItems");

        // Check if it's an order submission or if just a product is added to the cart
        if (orderSubmission != null && !orderSubmission.isEmpty() && orderSubmission.equals("regularShoppingCart")) {
            // Handle the order submission
            forwardOrderToCheckout(request);
            
            // Set the request target
            forwardRequestTarget = "checkout-page.jsp";
        } else if (shoppingCartButton != null && !shoppingCartButton.isEmpty() && shoppingCartButton.equals("delete")) {
            // Get the current shopping cart item
            String itemIndexString = request.getParameter("index");
            int itemIndex = Integer.parseInt(itemIndexString);

            // Delete an item depending on the button clicked
            deleteCartProduct(request, itemIndex);

            // Set the request target
            forwardRequestTarget = "order-page.jsp";
        } else if (productId != null && !productId.isEmpty()) {
            // Retrieve the selected options
            String[] options = request.getParameterValues("selectedOptions");

            // Add the new product and return the current shopping cart list
            addProductToShoppingCart(request, productId, options);

            // Set the request target
            forwardRequestTarget = "order-page.jsp";
        } else if (filter != null && !filter.isEmpty()) {
            // Check if a filter is active
            if (filter.equals("AllProducts")) {
                // Return the complete product list
                forwardProductList(request);
            } else {
                // Return the filtered product list
                forwardFilteredProductList(request, filter);
            }

            // Set the request target
            forwardRequestTarget = "order-page.jsp";
        } else if (deleteAllItems != null && !deleteAllItems.isEmpty() && deleteAllItems.equals("deleteCart")) {
            // Delete all items inside the shopping cart
            deleteAllCartItems(request);

            // Set the request target
            forwardRequestTarget = "order-page.jsp";
        } else {
            // Invalid request
            return;
        }

        // Forward the request to the corresponding JSP page
        forwardRequestDispatcher(request, response, forwardRequestTarget);
    }

    /**
     * @brief   Retrieves all Products as List
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private List<Products> getCompleteProductListAsList() {
        // Get all available products
        List<Products> productList = ProductList.getProductsAsList();

        return productList;
    }

    /**
     * @brief   Forward the product list data directly to a JSP page
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void forwardProductList(HttpServletRequest request) {
        // Set the data as an attribute in the request or session scope
        request.getSession().setAttribute("productList", completeProductList);
    }

    
    /**
     * @brief   Filters the product list with the given filter
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void forwardFilteredProductList(HttpServletRequest request, String filterOption) {
        // Get the filtered list
        List<Products> filteredList = ProductList.filterProductList(filterOption);

        // Set the data as an attribute in the request or session scope
        request.getSession().setAttribute("productList", filteredList);
    }

    /**
     * @brief   Adds a product to the shopping cart
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void addProductToShoppingCart(HttpServletRequest request, String productId, String[] options) {
        // Find the product from the available product list
        Products product = ProductList.getProductByIdWithoutReference(completeProductList, Integer.parseInt(productId));

        // Check if a product has been found
        if (product != null) {
            // Check if options have been selected
            if (options != null) {
                // Get the data of all selected options from the product
                HashMap<String, Double> selectedOptions = ProductList.getProductOptionsFromKeys(product, options);
    
                // Save the selected options
                product.replaceAllOptions(selectedOptions);
            } else {
                // Delete all options
                product.deleteAllOptions();
            }

            // Add the selected product to the cart
            shoppingCart.add(product);
        }

        // Set the data as an attribute in the request or session scope
        request.getSession().setAttribute("shoppingCart", shoppingCart);
    }

    /**
     * @brief   Handles the order submission and sends the cart items to the check-out page
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void forwardOrderToCheckout(HttpServletRequest request) {
        // Set the data as an attribute in the request or session scope
        request.getSession().setAttribute("orderedItems", shoppingCart);

    }

    /**
     * @brief   Deletes a product from the shopping cart
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void deleteCartProduct(HttpServletRequest request, int index) {
        // Remove the item from the specified index in the shopping cart
        shoppingCart.remove(index);

        // Set the data as an attribute in the request or session scope
        request.getSession().setAttribute("shoppingCart", shoppingCart);
    }

    /**
     * @brief   Deletes all items inside the shopping cart
     *
     * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
     */
    private void deleteAllCartItems(HttpServletRequest request) {
        // Delete all items from the cart
        shoppingCart.clear();

        // Set the data as an attribute in the request or session scope
        request.getSession().setAttribute("shoppingCart", shoppingCart);
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
