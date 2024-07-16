package cl.praxis.startupv2.dao.impl;

import cl.praxis.startupv2.connection.MySqlConnection;
import cl.praxis.startupv2.dao.IAddressDAO;
import cl.praxis.startupv2.model.AddressDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAOImpl implements IAddressDAO {

    final private Connection con;

    public AddressDAOImpl(){
        try {
            this.con = MySqlConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public AddressDTO addAddress(AddressDTO address) {
        try {
            var insertQuery = "INSERT INTO direcciones (nombre, numeracion, usuario_id) VALUES (?, ?, ?)";
            final PreparedStatement stmt = con.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            try(stmt){
                stmt.setString(1, address.getAddressName());
                stmt.setString(2, address.getAddressNumber());
                stmt.setInt(3, address.getUserId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    address.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return address;
    }
}
