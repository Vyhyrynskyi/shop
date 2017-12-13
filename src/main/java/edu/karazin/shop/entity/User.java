package edu.karazin.shop.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    //XXX как работают Lazy поля в спринге?
    
    private String password;
    //TODO add to DAO and constructor
    private String firstName;//from here
    private String lastName;
    private String email;
    
    
    //OneBox - крутая тема
    
    //TODO admin может пополнить счёт пользователю
    private Long balance;//to here
    
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
