package af.hu.cs.se.controller;

import af.hu.cs.se.model.User;
import af.hu.cs.se.service.PermissionService;
import af.hu.cs.se.service.RoleService;
import af.hu.cs.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String register(@ModelAttribute User user) {

        userService.createUser(user);

        return "redirect:/student/list";
    }
}
