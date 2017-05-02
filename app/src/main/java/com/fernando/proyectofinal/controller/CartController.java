package com.fernando.proyectofinal.controller;

import android.app.Application;

import com.fernando.proyectofinal.model.Cart;

/**
 * Created by Dell on 30/04/2017.
 */

public class CartController extends Application{
    private Cart shoppingCart = new Cart();

    public CartController(){

    }

    public CartController(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Cart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
