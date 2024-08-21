package com.example.burgerparadiesonlineshop.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.example.burgerparadiesonlineshop.Entity.Users;
import com.example.burgerparadiesonlineshop.Model.UserList;

/**
 * @brief   Servlet for the login page
 *
 * @author  Amjad Alnakshbandi
 * @author  Xiao-Ou Wang <hoshizawa.yuriko@gmail.com>
 */
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Initialization
        boolean loggedIn = false;
        HttpSession session = request.getSession();

        // Retrieve the credentials
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Find the user with matching credentials
        Users registeredUser = UserList.getUserByUsernameAndPassword(username, password);

        // Check if an User has been found
        if (registeredUser != null) {
            // Weiterleitung zur Startseite nach erfolgreicher Anmeldung
            loggedIn = true;
            session.setAttribute("loggedIn", loggedIn);
            session.setAttribute("user", registeredUser);
            if (registeredUser.getUserRoleId() == 2) {
                    response.sendRedirect("employee.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            // Weiterleitung zur Anmeldeseite mit Fehlermeldung
            request.setAttribute("errorMessage", "Ungültiger Benutzername oder Passwort");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
