package sap.gb.spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sap.gb.spring_boot.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
