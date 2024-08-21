package com.example.burgerparadiesonlineshop.Controller;

import java.io.*;

import com.example.burgerparadiesonlineshop.Entity.Users;
import com.example.burgerparadiesonlineshop.Model.UserList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * @brief   Servlet for the register page
 *
 * @author  Amjad Alnakshbandi
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
@WebServlet(name = "RegisterController", urlPatterns = "/RegisterController")
public class RegisterController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        String street = request.getParameter("street");
        String housenumber = request.getParameter("housenumber");
        String addressSupplement = request.getParameter("addressSupplement");
        String city = request.getParameter("city");
        String zipcode = request.getParameter("zipcode");

        // Get the highest available User-ID
        int newUserId = UserList.getAvailableId();

        // Create a new user
        Users user = new Users(
            newUserId,
            1,
            firstname,
            lastname,
            username,
            password,
            email,
            phonenumber,
            street,
            housenumber,
            addressSupplement,
            city,
            zipcode
        );

        // Save the user to the user list
        UserList.addUserToList(user);

        // Set the current user in the current session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // Nach erfolgreicher Registrierung, weiterleitung zur loginseite
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}