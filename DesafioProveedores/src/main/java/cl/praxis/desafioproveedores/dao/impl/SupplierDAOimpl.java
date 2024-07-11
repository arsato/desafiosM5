package cl.praxis.desafioproveedores.dao.impl;

import cl.praxis.desafioproveedores.connection.MySqlConnection;
import cl.praxis.desafioproveedores.dao.SupplierDAO;
import cl.praxis.desafioproveedores.model.SupplierDTO;
import com.mysql.cj.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOimpl implements SupplierDAO {

    private static final String SELECT_ALL_SUPPLIERS = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM proveedores";

    private static final String SELECT_SUPPLIER_BY_ID = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM proveedores WHERE id = ?";

    private static final String INSERT_SUPPLIER_SQL = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_SUPPLIER_SQL = "UPDATE proveedores SET nombre = ?, rut = ?, direccion = ?, correo = ?, telefono = ?, contacto = ?, telefono_contacto = ? WHERE id = ?";

    private static final String DELETE_SUPPLIER_SQL = "DELETE FROM proveedores WHERE id = ?";


    @Override
    public SupplierDTO selectSupplierById(int id) {
        SupplierDTO supplier = null;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUPPLIER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("nombre");
                String rut = rs.getString("rut");
                String address = rs.getString("direccion");
                String email = rs.getString("correo");
                int phone = rs.getInt("telefono");
                String contactName = rs.getString("contacto");
                int contactPhone = rs.getInt("telefono_contacto");
                supplier = new SupplierDTO(id, name, rut, address, email, phone, contactName, contactPhone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supplier;
    }

    @Override
    public List<SupplierDTO> selectAllSuppliers() {
        List<SupplierDTO> suppliers = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUPPLIERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                String rut = rs.getString("rut");
                String address = rs.getString("direccion");
                String email = rs.getString("correo");
                int phone = rs.getInt("telefono");
                String contactName = rs.getString("contacto");
                int contactPhone = rs.getInt("telefono_contacto");
                suppliers.add(new SupplierDTO(id, name, rut, address, email, phone, contactName, contactPhone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suppliers;
    }

    @Override
    public SupplierDTO insertSupplier(SupplierDTO supplier) {
        SupplierDTO newSupplier = null;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUPPLIER_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getRut());
            preparedStatement.setString(3, supplier.getAddress());
            preparedStatement.setString(4, supplier.getEmail());
            preparedStatement.setInt(5, supplier.getPhone());
            preparedStatement.setString(6, supplier.getContactName());
            preparedStatement.setInt(7, supplier.getContactPhone());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                newSupplier = new SupplierDTO(id, supplier.getName(), supplier.getRut(), supplier.getAddress(), supplier.getEmail(), supplier.getPhone(), supplier.getContactName(), supplier.getContactPhone());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newSupplier;
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplier) {
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SUPPLIER_SQL)) {
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getRut());
            preparedStatement.setString(3, supplier.getAddress());
            preparedStatement.setString(4, supplier.getEmail());
            preparedStatement.setInt(5, supplier.getPhone());
            preparedStatement.setString(6, supplier.getContactName());
            preparedStatement.setInt(7, supplier.getContactPhone());
            preparedStatement.setInt(8, supplier.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supplier;
    }

    @Override
    public boolean deleteSupplier(int id) {
        boolean rowDeleted;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SUPPLIER_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }
}
