package com.example.burgerparadiesonlineshop.Model;

import java.util.ArrayList;
import java.util.List;

import com.example.burgerparadiesonlineshop.Entity.*;

/**
 * @brief   List of all orders and methods to manipulate the list
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class OrderList {
    // Initial List
    private static List<Orders> orderList = new ArrayList<>();

    // Return all orders as List
    public static List<Orders> getOrderList() {
        return orderList;
    }

    // Find an order via its id attribute (returns the reference to the order)
    public static Orders getOrderById(int targetId) {
        for (Orders order : orderList) {
            // Return the object if the id matches
            if (order.getId() == targetId) {
                return order;
            }
        }

        // Return null if the object is not found
        return null;
    }

    // Add an order to the list
    public static void addOrderToList(Orders order) {
        orderList.add(order);
    }

    // Get the highest available free id
    public static int getAvailableId() {
        return orderList.size() + 1;
    }

    // Change the order status of the given order
    public static void changeStatus(int orderId,int newStatus) {
        orderList.stream()
            .filter(element -> orderId == element.getId())
            .findFirst()
            .ifPresent(element -> {
                element.setOrderStatus(newStatus);
            });
    }
}
