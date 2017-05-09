package com.fernando.proyectofinal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 01/05/2017.
 */

public class ProductSet implements Serializable {
    private ArrayList<Product> productList;
    private String name, description;
    private int imageResourceId, id;

    public ProductSet(int id, ArrayList<Product> productSet, String name, String description, int imageResourceId) {
        this.productList = productSet;
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductSet(ArrayList<Product> productSet) {
        this.productList = productSet;
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

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
