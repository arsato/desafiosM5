package cl.praxis.desafioproveedores.controller;

import cl.praxis.desafioproveedores.model.SupplierDTO;
import cl.praxis.desafioproveedores.service.SupplierService;
import cl.praxis.desafioproveedores.service.impl.SupplierServiceimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("")
public class SupplierServlet extends HttpServlet {

    private SupplierService supplierService;

    // Método init para inicializar el DAO
    public void init() {
        supplierService = new SupplierServiceimpl();
    }

    // Método doGet para manejar las solicitudes GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertSupplier(request, response);
                    break;
                default:
                    listSuppliers(request, response);
                    break;
            }
        } catch(SQLException ex) {
            throw new ServletException(ex);
        }
    }
    // Método doPost para manejar las solicitudes POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    // Método para listar todos los usuarios
    private void listSuppliers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<SupplierDTO> suppliersList = supplierService.selectAllSuppliers();
        request.setAttribute("listSuppliers", suppliersList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // Método para mostrar el formulario para un nuevo usuario
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("supplier-form.jsp").forward(request, response);
    }

    // Método para insertar un nuevo usuario y redirigir a la lista de usuarios
    private void insertSupplier(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String rut = request.getParameter("rut");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String contactName = request.getParameter("contactName");
        int contactPhone = Integer.parseInt(request.getParameter("contactPhone"));
        SupplierDTO newSupplier = new SupplierDTO(name, rut, address, email, phone, contactName, contactPhone);
        supplierService.insertSupplier(newSupplier);
        response.sendRedirect("proveedores");
    }

}
