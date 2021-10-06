package com.ejemplo1.controller;

import java.util.List;

import com.ejemplo1.dao.FolderDao.FolderDao;
import com.ejemplo1.models.Folder;
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


@EnableAutoConfiguration(exclude={BatchAutoConfiguration.class})
@RestController
public class FolderController {

    @Autowired
    private FolderDao folderDao;

    @Autowired
    private JWTUtil jwtUtil; 
    
   
    @RequestMapping(value = "api/folder/{id}", method = RequestMethod.GET)
    public List<Folder> getUsuarios(@RequestHeader(value = "Authorization") String token, @PathVariable int id) {
    if(!validarToken(token) ){
        return null;
    }   
        return folderDao.getFolder(id);
    }

    private boolean validarToken(String token){
    String usuarioID = jwtUtil.getKey(token);
    return usuarioID != null;
    }

    @RequestMapping(value = "api/folder", method = RequestMethod.POST)
    public void createFolder(@RequestBody Folder folder) {
       
        folderDao.createFolder(folder);
    }
    @RequestMapping(value = "api/folder", method = RequestMethod.PUT)
    public void updateFolder(@RequestBody Folder folder) {
       
        folderDao.updateFolder(folder);
    }

    @RequestMapping(value = "api/folder/{id}", method = RequestMethod.DELETE)
    public void eliminar( @RequestHeader(value = "Authorization") String token,
        @PathVariable int id) {
 
            if(!validarToken(token) ){
                return;
            }   

            folderDao.deleteFolder(id);
    }
}