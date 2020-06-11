package sap.gb.spring_boot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sap.gb.spring_boot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    void saveUser(User user);

    List<User> findAll();

    Optional<User> findUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
