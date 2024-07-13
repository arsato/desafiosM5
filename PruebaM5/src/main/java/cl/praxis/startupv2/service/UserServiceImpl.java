package cl.praxis.startupv2.service;

import cl.praxis.startupv2.dao.IUserDAO;
import cl.praxis.startupv2.dao.UserDAOImpl;
import cl.praxis.startupv2.model.UserDTO;

public class UserServiceImpl implements IUserService {

    private final IUserDAO userDAO;

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
