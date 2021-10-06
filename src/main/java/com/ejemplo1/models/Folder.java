package com.ejemplo1.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "folder")
@ToString @EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor    
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "folder_id")
    private int folder_id;

   
    @Column(name = "user_id")
    private int user_id;

   
    @Column(name = "name")
    private String name;
    
    @Column(name = "create_at")
    private String create_at;

    public Folder() {
    }
    public Folder(int folder_id, int user_id, String name, String create_at) {
        this.folder_id = folder_id;
        this.user_id = user_id;
        this.name = name;
        this.create_at = create_at;
    }
    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    

    public int getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(int folder_id) {
        this.folder_id = folder_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

   
    
}
