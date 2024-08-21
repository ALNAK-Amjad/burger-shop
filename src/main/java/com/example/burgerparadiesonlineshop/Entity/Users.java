package com.example.burgerparadiesonlineshop.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @brief   User Class
 * 
 * @author  Amjad Alnakshbandi
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class Users  {
    private int id;
    private int userRoleId;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String street;
    private String houseNumber;
    private String addressSupplement;
    private String city;
    private String zipcode;
    private List<Orders> orderList = new ArrayList<>();

    // User Role mapping
    private static HashMap<Integer, String> userRoleMap = new HashMap<Integer, String>() {{
        put(1, "Kunde");
        put(2, "Mitarbeiter");
        put(3, "Debug User");
    }};

    // Contructors
    public Users() {}

    public Users(int id, int userRoleId, String firstname, String lastname, String username, String password, String email,
            String phoneNumber, String street, String houseNumber, String addressSupplement, String city,
            String zipcode) {
        this.id = id;
        this.userRoleId = userRoleId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.houseNumber = houseNumber;
        this.addressSupplement = addressSupplement;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Users(int id, int userRoleId, String firstname, String lastname, String username, String password, String email,
            String phoneNumber, String street, String houseNumber, String addressSupplement, String city,
            String zipcode, List<Orders> orderList) {
        this.id = id;
        this.userRoleId = userRoleId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.houseNumber = houseNumber;
        this.addressSupplement = addressSupplement;
        this.city = city;
        this.zipcode = zipcode;
        this.orderList = orderList;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddressSupplement() {
        return addressSupplement;
    }

    public void setAddressSupplement(String addressSupplement) {
        this.addressSupplement = addressSupplement;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Return the User Role of the current user as String
    public String getUserRoleString() {
        // Get the user role
        String userRole = userRoleMap.get(getUserRoleId());

        // Check if the user has a valid userRoleId set
        if (userRole != null) {
            return userRole;
        } else {
            return "Unbekannte Benutzerrolle";
        }
    }

    // Return all orders as List
    public List<Orders> getOrderList() {
        return orderList;
    }

    // Add an order to the list
    public void addOrderToList(Orders order) {
        orderList.add(order);
    }
}

