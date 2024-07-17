package cl.praxis.startupv2.dao.impl;

import cl.praxis.startupv2.connection.MySqlConnection;
import cl.praxis.startupv2.dao.IUsersRolesDAO;
import cl.praxis.startupv2.model.UsersRolesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersRolesDAOImpl implements IUsersRolesDAO {

    final private Connection con;

    public UsersRolesDAOImpl(){
        try {
            this.con = MySqlConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UsersRolesDTO addUserToRole(UsersRolesDTO userRole) {
        try {
            var insertQuery = "INSERT INTO roles_usuarios (usuario_id, rol_id) VALUES (?, ?)";
            final PreparedStatement stmt = con.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            try(stmt){
                stmt.setInt(1, userRole.getUserId());
                stmt.setInt(2, userRole.getRoleId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userRole;
    }
}
