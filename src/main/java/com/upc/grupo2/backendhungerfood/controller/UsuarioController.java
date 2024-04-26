package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.dtos.UsuarioDTO;
import com.upc.grupo2.backendhungerfood.entities.Usuario;
import com.upc.grupo2.backendhungerfood.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@Secured({"Donante"})
@RequestMapping("/HungerFood/Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //Registrar Usuario
    @PostMapping("/RegistrarUsuario")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
            usuario = usuarioService.registrarUsuario(usuario);
            usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
            return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar usuario");
        }
    }

    //Listar Usuarios
    @GetMapping("/ListarUsuarios")
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<UsuarioDTO> list = Arrays.asList(modelMapper.map(usuarioService.listarUsuarios(),
                    UsuarioDTO[].class));
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar usuarios");
        }
    }

    //Actualizar Usuario
    @PutMapping("/ActualizarUsuario")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
            usuario = usuarioService.actualizarUsuario(usuario);
            usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
            return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar usuario");
        }
    }

    //Eliminar Usuario
    @DeleteMapping("/EliminarUsuario/{id}")
    public ResponseEntity<UsuarioDTO> eliminarUsuario(@PathVariable("id") Long id){
        Usuario usuario;
        UsuarioDTO usuarioDTO;
        try{
            usuario = usuarioService.eliminarUsuario(id);
            ModelMapper modelMapper = new ModelMapper();
            usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
            return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar usuario");
        }
    }
}
