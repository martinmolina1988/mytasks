package com.ejemplo1.dao.FolderDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejemplo1.models.Folder;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class FolderDaoImp implements FolderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Folder> getFolder(int id) {
        String query = "FROM Folder WHERE user_id = :user_id";
        return entityManager.createQuery(query, Folder.class)
       .setParameter("user_id", id).getResultList();
    }
    
    @Override
    public void deleteFolder(int id) {
        Folder folder = entityManager.find(Folder.class, id);
        entityManager.remove(folder);
    }
    
    @Override
    public void createFolder(Folder folder) {
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        folder.setCreate_at(dateFormat.format(new Date()));
        entityManager.merge(folder);
    }
    @Override
    public void updateFolder(Folder folder) {

        entityManager.merge(folder);
    }
    
    

}
