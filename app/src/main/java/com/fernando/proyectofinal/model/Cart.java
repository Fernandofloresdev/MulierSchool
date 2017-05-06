package com.fernando.proyectofinal.model;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 30/04/2017.
 */

public class Cart {
    //This class will manage all the cart operations
    private MemberStore memberStore;
    private ArrayList<Product> productInCart = new ArrayList<>();
    private double totalSum=0;
    private static final Cart INSTANCE = new Cart();
    private int userId;

    private Cart(){
    }

    public static Cart getInstance(){
        return INSTANCE;
    }

    public void clear(){
        productInCart.clear();
    }

    public void addProduct(Product product){
        for(int i=0;i<productInCart.size();i++){
            if(productInCart.get(i).getId() == product.getId()){
                productInCart.get(i).setQuantity(productInCart.get(i).getQuantity()+1);
                return;
            }
        }
        productInCart.add(product);
    }

    public void subtractProduct(int position){
        int quantity=productInCart.get(position).getQuantity();
        if(quantity>1){
            productInCart.get(position).setQuantity(quantity-1);
        }

    }

    public void remove(int position){
        productInCart.remove(position);
    }

    public Product getProduct(int position){
        return productInCart.get(position);
    }

    public MemberStore getMemberStore() {
        return memberStore;
    }

    public void setMemberStore(MemberStore memberStore) {
        this.memberStore = memberStore;
    }

    public ArrayList<Product> getProductInCart() {
        return productInCart;
    }

    public void setProductInCart(ArrayList<Product> productInCart) {
        this.productInCart = productInCart;
    }

    public double getTotalSum() {
        totalSum=0;
        for (Product product: productInCart
             ) {
            totalSum +=product.getPrice()*product.getQuantity();

        }
        return totalSum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if(userId!=this.userId){
            clear();
        }
        this.userId = userId;
    }
}
