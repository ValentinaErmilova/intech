package com.example.intech.models;

import javax.persistence.*;

@Table(name="users")
@Entity
public class User {
    public enum Role {
        Admin, User
    }
    public User() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
