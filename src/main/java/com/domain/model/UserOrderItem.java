package com.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "user_order_item")
public class UserOrderItem extends IdentifiableModel{

    private UserOrder userOrder;
    private ShopStorage shopStorage;
    private int count;

    public UserOrderItem() {
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_order_id"))
    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_shop_storage_id"))
    public ShopStorage getShopStorage() {
        return shopStorage;
    }

    public void setShopStorage(ShopStorage shopStorage) {
        this.shopStorage = shopStorage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
