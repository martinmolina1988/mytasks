package com.ejemplo1.controller;

import java.util.List;

import com.ejemplo1.dao.TaskDao.TaskDao;
import com.ejemplo1.models.Task;
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
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private JWTUtil jwtUtil; 
    
   

    @RequestMapping(value = "api/task/{folder_id}", method = RequestMethod.GET)
    public List<Task> getUsuarios(@RequestHeader(value = "Authorization") String token,
    @PathVariable int folder_id) {

        
    if(!validarToken(token) ){
        return null;
    }   
        return taskDao.getTask(folder_id);
    }

    private boolean validarToken(String token){
    String usuarioID = jwtUtil.getKey(token);
    return usuarioID != null;
    }

    @RequestMapping(value = "api/createTask", method = RequestMethod.POST)
    public void createTask(@RequestBody Task task) {
       
        taskDao.createTask(task);
    }

    @RequestMapping(value = "api/task/{id}", method = RequestMethod.DELETE)
    public void deleteTask( @RequestHeader(value = "Authorization") String token,
        @PathVariable int id) {
 
            if(!validarToken(token) ){
                return;
            }   

            taskDao.deleteTask(id);
    }
}