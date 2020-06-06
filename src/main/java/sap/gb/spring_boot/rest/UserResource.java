package sap.gb.spring_boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sap.gb.spring_boot.exception.NoSuchUserException;
import sap.gb.spring_boot.service.UserService;
import sap.gb.spring_boot.model.User;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserResource {
    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/{id}/id")
    public User getUser(@PathVariable("id") Long id) {
        return userService.findUserById(id)
                .orElseThrow(NoSuchUserException::new);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}/id")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
