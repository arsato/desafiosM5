package cl.praxis.startupv2.service.impl;

import cl.praxis.startupv2.dao.IUserDAO;
import cl.praxis.startupv2.dao.impl.UserDAOImpl;
import cl.praxis.startupv2.model.UserDTO;
import cl.praxis.startupv2.service.IUserService;

import java.util.List;

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

    @Override
    public UserDTO getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<UserDTO> getAllUsersData() {
       return userDAO.getAllUsersData();
    }

    @Override
    public void updateCar(int id, int userId) {
        userDAO.updateCar(id, userId);
    }
}
