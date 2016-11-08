package com.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@Entity
@Table(name = "user")
public class User extends IdentifiableModel{

    private List<UserOrder> orders = new ArrayList<UserOrder>();
    private int money;
    private String login;
    private String password;
    private String email;
    private String country;
    private String role;

    public User() {
    }

    @OneToMany(mappedBy = "user")
    public List<UserOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrder> orders) {
        this.orders = orders;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
