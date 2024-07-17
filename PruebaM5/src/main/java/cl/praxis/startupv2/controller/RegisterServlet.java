package cl.praxis.startupv2.controller;

import cl.praxis.startupv2.model.AddressDTO;
import cl.praxis.startupv2.model.CarDTO;
import cl.praxis.startupv2.model.UserDTO;
import cl.praxis.startupv2.model.UsersRolesDTO;
import cl.praxis.startupv2.service.IUsersRolesService;
import cl.praxis.startupv2.service.impl.AddressServiceImpl;
import cl.praxis.startupv2.service.IAddressService;
import cl.praxis.startupv2.service.IUserService;
import cl.praxis.startupv2.service.impl.UserServiceImpl;
import cl.praxis.startupv2.service.impl.UsersRolesServiceImpl;
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
    private IAddressService addressService;
    private IUsersRolesService usersRolesService;

    public void init() {
        userService = new UserServiceImpl();
        addressService = new AddressServiceImpl();
        usersRolesService = new UsersRolesServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        UserDTO user = new UserDTO();
        AddressDTO address = new AddressDTO();
        UsersRolesDTO usersRoles = new UsersRolesDTO();
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setNick(request.getParameter("nick"));
        user.setPassword(request.getParameter("password"));
        user.setWeight(Integer.parseInt(request.getParameter("weight")));
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        user.setCar(new CarDTO(1, "Sin Automovil",""));
        UserDTO newUser = userService.createUser(user);
        if (newUser == null) {
            request.setAttribute("message", "Correo electrónico ya registrado");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        } else {
            address.setAddressName(request.getParameter("addressName"));
            address.setAddressNumber(request.getParameter("addressNumber"));
            address.setUserId(newUser.getId());
            addressService.saveAddress(address);
            usersRoles.setUserId(newUser.getId());
            usersRoles.setRoleId(Integer.parseInt(request.getParameter("role")));
            usersRolesService.addUserToRole(usersRoles);
            response.sendRedirect("login.jsp");
        }
    }
}
