package com.fernando.proyectofinal.model;

import com.fernando.proyectofinal.R;

import java.util.ArrayList;

/**
 * Created by Dell on 03/05/2017.
 */

public class DummyTest {
    public ArrayList<Order> orders;


    public ArrayList<Order> getSuccesfulOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        Member member = new Member("Maria huerfanita", 1);
        member.setImageResource(R.drawable.marivi);
        ArrayList<Product> products = getProducts();

        orders.add(new Order(member,products));
        return orders;
    }

    public ArrayList<Order> getEmptyOrders(){
        return null;
    }

    public ArrayList getProducts() {
        ArrayList productList = new ArrayList();
        productList.add(new Product(1, "bag1", "bag1", 15.2, R.drawable.bag1, 2));
        productList.add(new Product(2, "bag2", "bag2", 15.2, R.drawable.bag2, 9));
        productList.add(new Product(3, "bag3", "bag3", 15.2, R.drawable.bag3, 2));
        productList.add(new Product(4, "bag4", "bag4", 15.2, R.drawable.bag4, 5));
        productList.add(new Product(5, "bag5", "bag5", 15.2, R.drawable.bag5, 1));
        productList.add(new Product(6, "bag6", "bag6", 15.2, R.drawable.bag6, 0));


        return productList;
    }

    public MemberStore searchMemberStore(Integer... params){
        //this will be replaced with an Http action
        return new MemberStore("Maria", "La tienda de María ", R.drawable.kelvin,1);
    }
}
