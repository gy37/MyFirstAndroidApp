package com.example.myfirstapp.Items;

import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Book {
    @Id(autoincrement = true)
    private Long id;//要使用大写Long，小写long不行
    @Property
    private String name;
    @Property
    private String author;
    @Property
    private int page;
    @Property
    private double price;
    @Generated(hash = 1572699208)
    public Book(Long id, String name, String author, int page, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.page = page;
        this.price = price;
    }
    @Generated(hash = 1839243756)
    public Book() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPage() {
        return this.page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setId(long id) {
        this.id = id;
    }
}
