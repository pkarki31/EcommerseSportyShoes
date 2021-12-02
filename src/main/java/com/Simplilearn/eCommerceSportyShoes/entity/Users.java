package com.Simplilearn.eCommerceSportyShoes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String city;
    private String contact;
    private String numberofOrders;
    private String password;


    public Users(){super();}

    public Users(long id, String name, String city,String contact, String numberofOrders
    ,String password) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.contact = contact;
        this.numberofOrders = numberofOrders;
        this.password=password;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNumberofOrders() {
        return numberofOrders;
    }

    public void setNumberofOrders(String numberofOrders) {
        this.numberofOrders = numberofOrders;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
