package com.ejemplo1.dao;

import java.util.List;

import com.ejemplo1.models.Usuario;

public interface UsuarioDao {

List<Usuario> getUsuarios();

void eliminar(Long id);

void regisrar(Usuario usuario);

Usuario obtenerUsuarioPorCredenciales(Usuario usuario);


}