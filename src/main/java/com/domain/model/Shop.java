package com.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop extends IdentifiableModel {

    private List<ShopStorage> shopStorages = new ArrayList<ShopStorage>();

    private String name;

    public Shop() {

    }

    @OneToMany(mappedBy = "shop")
    public List<ShopStorage> getShopStorages() {
        return shopStorages;
    }

    public void setShopStorages(List<ShopStorage> shopStorages) {
        this.shopStorages = shopStorages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
