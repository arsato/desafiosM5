package cl.praxis.startupv2.service.impl;

import cl.praxis.startupv2.dao.IUsersRolesDAO;
import cl.praxis.startupv2.dao.impl.UsersRolesDAOImpl;
import cl.praxis.startupv2.model.UsersRolesDTO;
import cl.praxis.startupv2.service.IUsersRolesService;

public class UsersRolesServiceImpl implements IUsersRolesService {

    private final IUsersRolesDAO userRoleDao;

    public UsersRolesServiceImpl() {
        this.userRoleDao = new UsersRolesDAOImpl();
    }

    @Override
    public UsersRolesDTO addUserToRole(UsersRolesDTO userRole) {
        return userRoleDao.addUserToRole(userRole);
    }
}
