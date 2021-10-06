package com.ejemplo1.dao.TaskDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejemplo1.models.Task;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class TaskDaoImp implements TaskDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Task> getTask(int folder_id) {
        String query = "FROM Task  WHERE folder_id = :folder_id";
        return entityManager.createQuery(query, Task.class)
        .setParameter("folder_id", folder_id).getResultList();
    }
    
    @Override
    public void deleteTask(int id) {
        Task folder = entityManager.find(Task.class, id);
        entityManager.remove(folder);
    }
    
    @Override
    public void createTask(Task task) {
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        task.setCreate_at(dateFormat.format(new Date()));
        
        if(task.getCompleted() == null){
            task.setCompleted((short) 0);
        }
        entityManager.merge(task);
    }
    
    

}
