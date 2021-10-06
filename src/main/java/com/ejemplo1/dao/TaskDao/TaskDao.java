package com.ejemplo1.dao.TaskDao;

import java.util.List;

import com.ejemplo1.models.Task;


public interface TaskDao {
    
    List<Task> getTask(int folder_id);

    void deleteTask(int id);

    void createTask(Task folder);

}
