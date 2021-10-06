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
@Table(name = "user")
@ToString @EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor    
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int user_id;

   
    @Column(name = "email")
    private String email;

   
    @Column(name = "password")
    private String password;

    public Usuario() {
    }

   
    public Usuario(int user_id, String email, String password) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }
  

    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
