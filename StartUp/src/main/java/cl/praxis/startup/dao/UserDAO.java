package cl.praxis.startup.dao;

import cl.praxis.startup.model.UserDTO;

import java.util.List;

public interface UserDAO {

    public UserDTO getUserById(int id);
    public UserDTO getUserByEmail(String email);
    public List<UserDTO> getAllUsers();
    public UserDTO createUser(UserDTO user);
    public boolean updateUser(UserDTO user);
    public boolean deleteUser(int id);

}
