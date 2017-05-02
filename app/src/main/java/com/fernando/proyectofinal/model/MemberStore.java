package com.fernando.proyectofinal.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Dell on 22/04/2017.
 */

public class MemberStore implements Serializable {
    private String name, description;
    private int id, imageId;
    private ArrayList products;
    private boolean isEmpty;

    public MemberStore(){
        this.isEmpty=true;
    }

    public MemberStore(String name, String description, int imageId, int id){
        this.name=name;
        this.description=description;
        this.imageId=imageId;
        this.id = id;
        this.isEmpty=false;
    }

    public MemberStore(String name, String description, int imageId, int id,ArrayList<Product> products){
        this.name=name;
        this.description=description;
        this.imageId=imageId;
        this.products=products;
        this.id=id;
        this.isEmpty=false;
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

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public ArrayList getProducts() {
        return products;
    }

    public void setProducts(ArrayList products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
