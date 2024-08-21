package com.example.burgerparadiesonlineshop.Controller;

import com.example.burgerparadiesonlineshop.Entity.Orders;
import com.example.burgerparadiesonlineshop.Model.OrderList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController", "/employee.jsp"})
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Check if request is for showing the order details or changing the order status
        if (request.getParameter("orderDetail") != null) {
            // Get the Order-ID
            int orderIdForOrderDetail = Integer.parseInt(request.getParameter("orderDetail"));

            // Get the order
            Orders order = OrderList.getOrderById(orderIdForOrderDetail);

            // Return the order information to the employee page
            getServletContext().setAttribute("orderDetail", order);
            forwardRequestDispatcher(request, response, "employee.jsp");
        } else if (request.getParameter("statusChange") != null && request.getParameter("orderId") != null) {
            int newStatus;

            // Converting the string to the corresponding int
            String stringStatus = request.getParameter("statusChange");
            switch (stringStatus) {
                case "Bestellung erhalten":
                    newStatus = 1;
                    break;
                case "In Zubereitung":
                    newStatus = 2;
                    break;
               case "Wird Geliefert":
                    newStatus = 3;
                    break;
                case "Ausgeliefert":
                    newStatus = 4;
                    break;
                default:
                    newStatus = 1;
            }

            int orderId = Integer.parseInt(request.getParameter("orderId"));
            // Changing the status of the order
            OrderList.changeStatus(orderId, newStatus);
            getServletContext().setAttribute("completeOrderList", OrderList.getOrderList());
            forwardRequestDispatcher(request, response, "employee.jsp");
        }
    }

    private void forwardRequestDispatcher(HttpServletRequest request, HttpServletResponse response, String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}
