package com.domain.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    private Long id;
    private List<ShopStorage> shopStorages = new ArrayList<ShopStorage>();

    private String name;
    private int price;
    private Timestamp releaseDate;
    private Time length;

    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "movie")
    public List<ShopStorage> getShopStorages() {
        return shopStorages;
    }

    public void setShopStorages(List<ShopStorage> shopStorages) {
        this.shopStorages = shopStorages;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Time getLength() {
        return length;
    }

    public void setLength(Time length) {
        this.length = length;
    }
}
