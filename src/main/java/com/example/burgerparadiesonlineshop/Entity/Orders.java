package com.example.burgerparadiesonlineshop.Entity;

import java.util.HashMap;
import java.util.List;

/**
 * @brief   Orders Klasse mit allen Daten zu einer Bestellung
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class Orders {
    private int id;
    private int userId;
    private int orderStatus;
    private String firstname;
    private String lastname;
    private String street;
    private String housenumber;
    private String addressSupplement;
    private String city;
    private String zipcode;
    private String phone;
    private String paymentMethod;
    private List<Products> orderedItems;

    // Mapping for the order status ID
    private static HashMap<Integer, String> orderStatusMap = new HashMap<Integer, String>() {{
        put(1, "Bestellung erhalten");
        put(2, "In Zubereitung");
        put(3, "Wird Geliefert");
        put(4, "Ausgeliefert");
        put(99, "Bestellung Storniert");
    }};

    // Standard Constructor
    public Orders(int id, int userId, int orderStatus, String firstname, String lastname, String street, String housenumber,
                  String addressSupplement, String city, String zipcode, String phone, String paymentMethod,
                  List<Products> orderedItems) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.housenumber = housenumber;
        this.addressSupplement = addressSupplement;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.paymentMethod = paymentMethod;
        this.orderedItems = orderedItems;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getAddressSupplement() {
        return addressSupplement;
    }

    public void setAddressSupplement(String addressSupplement) {
        this.addressSupplement = addressSupplement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Products> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<Products> orderedItems) {
        this.orderedItems = orderedItems;
    }

    // Return the order status as String
    public String getOrderStatusString() {
        // Get the order status
        String orderStatusString = orderStatusMap.get(getOrderStatus());

        // Check if a valid order status ID is set
        if (orderStatusString != null) {
            return orderStatusString;
        } else {
            return "Fehler: Ungültiger Bestellstatus";
        }
    }

    // Return the total price of the order
    public double getTotalPrice() {
        // Init. return value
        double totalPrice = 0.0;

        // Get the price of all ordered products
        for (Products product : orderedItems) {
            // Add the product price to the total
            totalPrice += product.getPrice();

            // Add the prices of all selected options to the total
            for (double optionPrice : product.getOptions().values()) {
                totalPrice += optionPrice;
            }
        }

        return totalPrice;
    }
}
