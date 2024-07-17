package cl.praxis.startupv2.service;

import cl.praxis.startupv2.model.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO createUser(UserDTO user);

    UserDTO verifyUser(String email);

    UserDTO getUserById(int id);

    List<UserDTO> getAllUsersData();

    void updateCar(int id, int userId);
}