package com.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_storage")
public class ShopStorage extends IdentifiableModel {

    private Movie movie;
    private Shop shop;
    private List<UserOrderItem> userOrderItems = new ArrayList<UserOrderItem>();

    private int count;

    public ShopStorage() {
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_movie_id"))
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_shop_id"))
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @OneToMany(mappedBy = "shopStorage")
    public List<UserOrderItem> getUserOrderItems() {
        return userOrderItems;
    }

    public void setUserOrderItems(List<UserOrderItem> userOrderItems) {
        this.userOrderItems = userOrderItems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
