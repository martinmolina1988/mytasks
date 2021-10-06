package com.ejemplo1.dao.FolderDao;

import java.util.List;

import com.ejemplo1.models.Folder;

public interface FolderDao {
    
    List<Folder> getFolder(int id);

    void deleteFolder(int id);

    void createFolder(Folder folder);
    void updateFolder(Folder folder);

}
