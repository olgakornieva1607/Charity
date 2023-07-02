package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Role;

import java.util.List;

public interface RoleService {

    Role findByName(String name);

    List<Role> findAll();
}
