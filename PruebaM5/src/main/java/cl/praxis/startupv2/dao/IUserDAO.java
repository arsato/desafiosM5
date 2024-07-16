package cl.praxis.startupv2.dao;

import cl.praxis.startupv2.model.UserDTO;

import java.util.List;

public interface IUserDAO {

    public UserDTO getUserById(int id);
    public UserDTO getUserByEmail(String email);
    public List<UserDTO> getAllUsersData();
    public UserDTO createUser(UserDTO user);
    public boolean updateUser(UserDTO user);
    public boolean deleteUser(int id);

}
