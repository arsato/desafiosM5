package cl.praxis.startup.service;

import cl.praxis.startup.dao.UserDAO;
import cl.praxis.startup.dao.UserDAOImpl;
import cl.praxis.startup.model.UserDTO;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }


    @Override
    public UserDTO createUser(UserDTO user) {
        UserDTO newUser = userDAO.getUserByEmail(user.getEmail());
        if (newUser == null) {
            return userDAO.createUser(user);
        } else {
            return null;
        }
    }

    @Override
    public UserDTO verifyUser(String email) {
        return userDAO.getUserByEmail(email);
    }
}
