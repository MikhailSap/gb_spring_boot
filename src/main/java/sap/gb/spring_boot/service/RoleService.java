package sap.gb.spring_boot.service;

import sap.gb.spring_boot.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
}
