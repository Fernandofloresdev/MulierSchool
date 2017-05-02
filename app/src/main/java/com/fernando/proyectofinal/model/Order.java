package com.fernando.proyectofinal.model;

import java.util.ArrayList;

/**
 * Created by Dell on 02/05/2017.
 */

public class Order {
    private Member member;
    private ArrayList<Product> productOrder;


    public Order(Member member, ArrayList<Product> productOrder) {
        this.member = member;
        this.productOrder = productOrder;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ArrayList<Product> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ArrayList<Product> productOrder) {
        this.productOrder = productOrder;
    }
}
