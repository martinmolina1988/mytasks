package com.ejemplo1.controller;

import java.util.ArrayList;
import java.util.List;

import com.ejemplo1.dao.UsuarioDao;
import com.ejemplo1.models.Usuario;
import com.ejemplo1.utils.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@EnableAutoConfiguration(exclude={BatchAutoConfiguration.class})
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil; 
    
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public ArrayList<Usuario> getUsuario(@PathVariable Long id)  {
       ArrayList<Usuario> usuarios = new ArrayList<>();
       List<String> lista = new  ArrayList<>();
        lista.add("hola");
        lista.add("chau");
        lista.add("pito");
       usuarios.add(new Usuario(1, "email", "password"));
       usuarios.add(new Usuario(2, "email", "password"));
       usuarios.add(new Usuario(3, "email", "password"));

       for (Usuario us : usuarios) {
           System.out.println(us.getEmail());
       }
        return usuarios;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
    if(!validarToken(token) ){
        return null;
    }   
        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token){
    String usuarioID = jwtUtil.getKey(token);
    return usuarioID != null;
    }

    @RequestMapping(value = "api/registrar", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
       
        Argon2 argon2 = Argon2Factory .create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.regisrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar( @RequestHeader(value = "Authorization") String token,
        @PathVariable Long id) {
 
            if(!validarToken(token) ){
                return;
            }   

            usuarioDao.eliminar(id);
    }
}