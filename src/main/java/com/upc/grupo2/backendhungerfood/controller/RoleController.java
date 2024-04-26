package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.entities.Role;
import com.upc.grupo2.backendhungerfood.services.RoleService;
import com.upc.grupo2.backendhungerfood.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/new")
    public String newRole(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("listaUsuarios", usuarioService.listarUsuarios());
        return "role/role";
    }

    @PostMapping("/save")
    public String saveRole(Role role, Model model) {
        roleService.insert(role);
        model.addAttribute("mensaje", "Se guardó correctamente");
        model.addAttribute("listaRoles", roleService.list());
        return "role/role";
    }

    @GetMapping("/list")
    public String listRole(Model model) {
        try {
            model.addAttribute("role", new Role());
            model.addAttribute("listaRoles", roleService.list());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "role/listRole";
    }
}
