package af.hu.cs.se.controller;

import af.hu.cs.se.model.Permission;
import af.hu.cs.se.model.Role;
import af.hu.cs.se.model.User;
import af.hu.cs.se.service.PermissionService;
import af.hu.cs.se.service.RoleService;
import af.hu.cs.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/login")
    public String login() {

        return "login";
    }


    @GetMapping("/user/register")
    public String register(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAllRoles());
        model.addAttribute("permissions", permissionService.findAllPermissions());
        return "user/user-form";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute User user,
                           @RequestParam List<Integer> roleIds,
                           @RequestParam List<Integer> permissionIds) {

        //userService.createUser(user);

        if(!permissionIds.isEmpty()) {
//            permissionIds.remove(0);
          List<Permission> permissions = permissionService.findAllPermissionsById(permissionIds);
          user.setPermissions(new HashSet<>(permissions));
        }

        List<Role> roles = roleService.findAllRolesByIds(roleIds);
        user.setRoles(new HashSet<>(roles));
        user.encodePassword();


        //userService.createUser(user);

       // System.out.println();
        System.out.println(roles.get(0).getRoleName());

        userService.createUser(user);

        return "redirect:/student/list";
    }

    @GetMapping("/login/success")
    public String afterLogin() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username);

        Set<Role> userRoles = user.getRoles();

        if (userRoles.contains(roleService.findRoleByRoleName("ROLE_ADMIN"))) {
            return "redirect:/admin";
        } else if (userRoles.contains(roleService.findRoleByRoleName("ROLE_LECTURER"))) {
            return "redirect:/lecturer/" + user.getId() + "/details";
        } else if (userRoles.contains(roleService.findRoleByRoleName("ROLE_STUDENT"))) {
            return "redirect:/student/" + user.getId() + "/details";
        }

        return "redirect:/";
    }
}
