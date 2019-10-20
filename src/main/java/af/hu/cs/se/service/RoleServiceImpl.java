package af.hu.cs.se.service;

import af.hu.cs.se.model.Role;
import af.hu.cs.se.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
