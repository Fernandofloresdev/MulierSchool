package com.fernando.proyectofinal.model;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 30/04/2017.
 */

public class Cart {
    //This class will manage all the cart operations
    public MemberStore memberStore;
    public List<Product> productInCart;

    public Cart(){

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

    public List<Product> getProductInCart() {
        return productInCart;
    }

    public void setProductInCart(List<Product> productInCart) {
        this.productInCart = productInCart;
    }
}
