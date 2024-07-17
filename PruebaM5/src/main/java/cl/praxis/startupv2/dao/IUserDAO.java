package cl.praxis.startupv2.dao;

import cl.praxis.startupv2.model.UserDTO;

import java.util.List;

public interface IUserDAO {

    UserDTO getUserById(int id);
    UserDTO getUserByEmail(String email);
    List<UserDTO> getAllUsersData();
    UserDTO createUser(UserDTO user);
    void updateCar(int id, int userId);

}
