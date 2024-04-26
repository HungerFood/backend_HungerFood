package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.entities.Role;
import com.upc.grupo2.backendhungerfood.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    //agregar
    public void insert(Role role) {
        roleRepository.save(role);
    }

    //listar
    public Iterable<Role> list() {
        // TODO Auto-generated method stub
        return roleRepository.findAll();
    }
}
