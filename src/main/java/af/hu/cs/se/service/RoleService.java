package af.hu.cs.se.service;

import af.hu.cs.se.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();

    List<Role> findAllRolesByIds(List<Integer> roleIds);
}
