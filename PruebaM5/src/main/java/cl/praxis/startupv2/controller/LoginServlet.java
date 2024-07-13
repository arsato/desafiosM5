package cl.praxis.startupv2.controller;

import cl.praxis.startupv2.model.UserDTO;
import cl.praxis.startupv2.service.IUserService;
import cl.praxis.startupv2.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private IUserService userService;

    public void init() {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDTO user = userService.verifyUser(email);
        if (user == null) {
            request.setAttribute("message", "mail not found");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            if (user.getPassword().equals(password)) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("home.jsp").forward(request, response);

            } else {
                request.setAttribute("message", "wrong password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }

    }

}
