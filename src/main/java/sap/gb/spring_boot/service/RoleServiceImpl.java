package sap.gb.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sap.gb.spring_boot.model.Role;
import sap.gb.spring_boot.repo.RoleRepo;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }
}
