package com.ejemplo1.controller;

import com.ejemplo1.dao.UsuarioDao;
import com.ejemplo1.models.Usuario;
import com.ejemplo1.utils.JWTUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
       
        Usuario userLogger = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (userLogger != null) {
          String tokenJWT =  jwtUtil.create(String.valueOf(userLogger.getUser_id()), userLogger.getEmail());
            
            return tokenJWT;

        }
        return "FAIL";
    }
}
