package sap.gb.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sap.gb.spring_boot.model.User;
import sap.gb.spring_boot.service.RoleService;
import sap.gb.spring_boot.service.UserService;


@Controller
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAll());
        return "user";
    }

    @PostMapping("user")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
}
