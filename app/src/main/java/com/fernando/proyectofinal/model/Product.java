package com.fernando.proyectofinal.model;

import java.io.Serializable;

/**
 * Created by Dell on 29/04/2017.
 */

public class Product implements Serializable{
    private String name,description;
    private double price;
    private int id, imageResource, availability,quantity;

    public Product(int id, String name, String description, double price, int imageResource, int availability) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResource = imageResource;
        this.availability = availability;
        quantity=1;
    }

    public Product(int id, String name, String description, double price, int imageResource, int availability, int quantity) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResource = imageResource;
        this.availability = availability;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
