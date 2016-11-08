package com.domain.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_order")
public class UserOrder {

    private Long id;
    private User user;
    private List<UserOrderItem> orders = new ArrayList<UserOrderItem>();
    private Date date;

    public UserOrder() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_id"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "userOrder")
    public List<UserOrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrderItem> orders) {
        this.orders = orders;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
