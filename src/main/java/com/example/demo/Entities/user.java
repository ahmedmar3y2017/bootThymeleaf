package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NotNull
    @Size(min = 2, max = 20)
    String username;
    @NotNull
    @Size(min = 6, max = 225)
    String password;
    @NotNull
    @Size(min = 2, max = 20)
    String role;


    public user() {
    }

    public user(@NotNull @Size(min = 2, max = 20) String username, @NotNull @Size(min = 6, max = 20) String password, @NotNull @Size(min = 2, max = 20) String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
