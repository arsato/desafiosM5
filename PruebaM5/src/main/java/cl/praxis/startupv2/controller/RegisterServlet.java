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
import java.sql.Timestamp;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private IUserService userService;

    public void init() {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        UserDTO user = new UserDTO();
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setNick(request.getParameter("nick"));
        user.setPassword(request.getParameter("password"));
        user.setWeight(Integer.parseInt(request.getParameter("weight")));
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        UserDTO newUser = userService.createUser(user);
        if (newUser == null) {
            request.setAttribute("message", "Correo electrónico ya registrado");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        } else
            response.sendRedirect("login.jsp");
    }

}
