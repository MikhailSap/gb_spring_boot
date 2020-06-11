package sap.gb.spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sap.gb.spring_boot.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
