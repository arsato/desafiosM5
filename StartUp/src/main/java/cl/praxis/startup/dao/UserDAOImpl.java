package cl.praxis.startup.dao;

import cl.praxis.startup.connection.MySqlConnection;
import cl.praxis.startup.model.UserDTO;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    final private Connection con;

    public UserDAOImpl(){
        try {
            this.con = MySqlConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public UserDTO getUserById(int id) {
        return null;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserDTO user = null;
        try{
            var selectQuery = "SELECT id, correo, created_at, nick, nombre, password, peso, updated_at FROM usuarios WHERE correo = ?";
            final PreparedStatement stmt = con.prepareStatement(selectQuery);
            try(stmt){
                stmt.setString(1, email);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    user = new UserDTO();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("correo"));
                    user.setCreatedAt(rs.getTimestamp("created_at"));
                    user.setNick(rs.getString("nick"));
                    user.setName(rs.getString("nombre"));
                    user.setPassword(rs.getString("password"));
                    user.setWeight(rs.getInt("peso"));
                    user.setUpdatedAt(rs.getTimestamp("updated_at"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        try {
            var insertQuery = "INSERT INTO usuarios (correo, created_at, nick, nombre, password, peso, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
            final PreparedStatement stmt = con.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            try(stmt){
                stmt.setString(1, user.getEmail());
                stmt.setTimestamp(2, user.getCreatedAt());
                stmt.setString(3, user.getNick());
                stmt.setString(4, user.getName());
                stmt.setString(5, user.getPassword());
                stmt.setInt(6, user.getWeight());
                stmt.setTimestamp(7, user.getUpdatedAt());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean updateUser(UserDTO user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

}
