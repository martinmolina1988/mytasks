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
@Table(name = "task")
@ToString @EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor    
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private int task_id;

    @Column(name = "folder_id")
    private int folder_id;
   
    @Column(name = "user_id")
    private int user_id;
   
    @Column(name = "completed")
    private Short completed;

   
    @Column(name = "description")
    private String description;
    
    @Column(name = "create_at")
    private String create_at;


    

    public Task() {
    }

    public Task(int task_id, int folder_id, int user_id, Short completed, String description, String create_at) {
        this.task_id = task_id;
        this.folder_id = folder_id;
        this.user_id = user_id;
        this.completed = completed;
        this.description = description;
        this.create_at = create_at;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
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

    public Short getCompleted() {
        return completed;
    }

    public void setCompleted(Short completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

   
    

   
    
}
