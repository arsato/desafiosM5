package cl.praxis.startup.service;

import cl.praxis.startup.model.UserDTO;

public interface UserService {

    public UserDTO createUser(UserDTO user);
    public UserDTO verifyUser(String email);
}
