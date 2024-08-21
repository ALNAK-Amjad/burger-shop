package com.example.burgerparadiesonlineshop.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.burgerparadiesonlineshop.Entity.Users;

/**
 * @brief   List of all current users and methods to manipulate the list
 *
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class UserList {
    // Initial List
    private static List<Users> userList = new ArrayList<>(Arrays.asList(
        // Regular User (for placing orders)
        new Users(
            1,
            1,
            "Marius",
            "Baumer",
            "mbaumer",
            "12345",
            "marius.baumer@notarealaddress.info",
            "01943-9099999999999",
            "Steinfelder Straße",
            "99b",
            "Seitenhaus B",
            "Großdammerstadt",
            "99990"
        ),
        // Debug User
        new Users(
            2,
            3,
            "Debug User",
            "Nachname",
            "debug",
            "1",
            "debug@notarealaddress.info",
            "00000-0000000000000",
            "Straße",
            "Hausnummer",
            "Adresszusatz",
            "Ort",
            "99999"
        ),
        // Employee User (for changing the order status)
        new Users(
            3,
            2,
            "Mitarbeiter User",
            "Nachname",
            "mt",
            "1",
            "mt@notarealaddress.info",
            "00000-0000000000000",
            "Straße",
            "Hausnummer",
            "Adresszusatz",
            "Ort",
            "99999"
        )
    ));

    // Return all users as List
    public static List<Users> getUserList() {
        return userList;
    }

    // Add an user to the list
    public static void addUserToList(Users user) {
        userList.add(user);
    }

    // Get the highest available free id
    public static int getAvailableId() {
        return userList.size() + 1;
    }

    // Get a specific user from its username and password
    public static Users getUserByUsernameAndPassword(String username, String password) {
        // Find the user with a matching username and password
        for (Users currentUser : userList) {
            // Return the found user if the username and password matches
            if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword())) {
                return currentUser;
            }
        }

        return null;
    }
}
