package com.PHC.Entity;

import jakarta.persistence.*;
import org.hibernate.tool.schema.spi.SchemaTruncator;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name",nullable = false,unique = true)
    private String name;
    @Column(name="email",unique = true)
    private String email;
    @Column(name="passwd",unique = true)
    private String passwd;
    @Column(name="role",nullable = false)
    private String role;

    public User(int id, String name, String email, String passwd, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.role = role;
    }

    public User() {
    }

    public User(String name, String email, String passwd, String role) {
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
