package cl.praxis.startupv2.dao.impl;

import cl.praxis.startupv2.connection.MySqlConnection;
import cl.praxis.startupv2.dao.IUserDAO;
import cl.praxis.startupv2.model.AddressDTO;
import cl.praxis.startupv2.model.CarDTO;
import cl.praxis.startupv2.model.RoleDTO;
import cl.praxis.startupv2.model.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {

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
            var selectQuery = "SELECT" +
                    " u.id," +
                    " u.correo," +
                    " u.created_at," +
                    " u.nick," +
                    " u.nombre," +
                    " u.password," +
                    " u.peso," +
                    " u.updated_at," +
                    " d.id," +
                    " d.nombre," +
                    " d.numeracion," +
                    " d.usuario_id," +
                    " r.nombre," +
                    " a.nombre," +
                    " a.img_url" +
                    " FROM usuarios u" +
                    " LEFT JOIN direcciones d ON u.id = d.usuario_id" +
                    " LEFT JOIN roles_usuarios ru ON u.id = ru.usuario_id" +
                    " LEFT JOIN roles r ON ru.rol_id = r.id" +
                    " LEFT JOIN autos a ON u.id_auto = a.id" +
                    " WHERE u.correo = ?";
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
                    user.setAddress(new AddressDTO(rs.getInt("d.id"), rs.getString("d.nombre"), rs.getString("d.numeracion"), rs.getInt("d.usuario_id")));
                    user.setRole(new RoleDTO(rs.getString("r.nombre")));
                    user.setCar(new CarDTO(rs.getString("a.nombre"), rs.getString("a.img_url")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<UserDTO> getAllUsersData() {
        UserDTO user = null;
        List<UserDTO> users = new ArrayList<>();
        try {
            var selectQuery = "SELECT" +
                    " u.id," +
                    " u.correo," +
                    " u.created_at," +
                    " u.nick," +
                    " u.nombre," +
                    " u.password," +
                    " u.peso," +
                    " u.updated_at," +
                    " d.id," +
                    " d.nombre," +
                    " d.numeracion," +
                    " d.usuario_id," +
                    " r.nombre," +
                    " a.nombre," +
                    " a.img_url" +
                    " FROM usuarios u" +
                    " LEFT JOIN direcciones d ON u.id = d.usuario_id" +
                    " LEFT JOIN roles_usuarios ru ON u.id = ru.usuario_id" +
                    " LEFT JOIN roles r ON ru.rol_id = r.id" +
                    " LEFT JOIN autos a ON u.id_auto = a.id";

            final PreparedStatement stmt = con.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            try(stmt){
                while (rs.next()) {
                    user = new UserDTO();
                    user.setId(rs.getInt("u.id"));
                    user.setEmail(rs.getString("u.correo"));
                    user.setCreatedAt(rs.getTimestamp("u.created_at"));
                    user.setNick(rs.getString("u.nick"));
                    user.setName(rs.getString("u.nombre"));
                    user.setPassword(rs.getString("u.password"));
                    user.setWeight(rs.getInt("u.peso"));
                    user.setUpdatedAt(rs.getTimestamp("u.updated_at"));
                    user.setAddress(new AddressDTO(rs.getInt("d.id"), rs.getString("d.nombre"), rs.getString("d.numeracion"), rs.getInt("d.usuario_id")));
                    user.setRole(new RoleDTO(rs.getString("r.nombre")));
                    user.setCar(new CarDTO(rs.getString("a.nombre"), rs.getString("a.img_url")));
                    users.add(user);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
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

