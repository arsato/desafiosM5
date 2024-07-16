package cl.praxis.startupv2.service;

import cl.praxis.startupv2.model.UserDTO;

import java.util.List;

public interface IUserService {

    public UserDTO createUser(UserDTO user);

    public UserDTO verifyUser(String email);

    public List<UserDTO> getAllUsersData();
}