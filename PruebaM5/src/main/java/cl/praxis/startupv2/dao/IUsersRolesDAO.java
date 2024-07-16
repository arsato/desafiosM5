package cl.praxis.startupv2.dao;

import cl.praxis.startupv2.model.RoleDTO;
import cl.praxis.startupv2.model.UserDTO;
import cl.praxis.startupv2.model.UsersRolesDTO;

public interface IUsersRolesDAO {

    public UsersRolesDTO addUserToRole(UsersRolesDTO userRole);
}
