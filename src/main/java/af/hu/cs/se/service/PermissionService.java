package af.hu.cs.se.service;

import af.hu.cs.se.model.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAllPermissions();
}
