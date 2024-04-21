package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.entities.Usuario;
import com.upc.grupo2.backendhungerfood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Registrar Usuario
    @Transactional //cualquier error no se crear la entidad y el id no se incrementará
    public Usuario registrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    //Listar Usuarios
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
    //Actualizar Usuario
    public Usuario actualizarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    //Eliminar Usuario
    public Usuario eliminarUsuario(Long id) throws Exception {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new Exception("No se encontró entidad"));
        usuarioRepository.delete(usuario);
        return usuario;
    }
}
