package cl.praxis.startupv2.dao;

import cl.praxis.startupv2.model.UsersRolesDTO;

public interface IUsersRolesDAO {

    UsersRolesDTO addUserToRole(UsersRolesDTO userRole);
}
