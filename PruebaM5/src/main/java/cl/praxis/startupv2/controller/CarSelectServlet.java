package cl.praxis.startupv2.controller;

import cl.praxis.startupv2.model.UserDTO;
import cl.praxis.startupv2.service.IUserService;
import cl.praxis.startupv2.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/carselect")
public class CarSelectServlet extends HttpServlet {

    private IUserService userService;

    public void init() {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selectedValue = request.getParameter("carSelect");
        int id = Integer.parseInt(selectedValue.split("-")[1]);
        int userId = Integer.parseInt(selectedValue.split("-")[0]);
        UserDTO user = userService.getUserById(userId);
        userService.updateCar(id, userId);
        List<UserDTO> usersList = userService.getAllUsersData();
        request.setAttribute("user", user);
        request.setAttribute("listUsers", usersList);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
