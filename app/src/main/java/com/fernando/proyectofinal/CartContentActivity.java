package com.fernando.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fernando.proyectofinal.controller.ProductInCartAdapter;
import com.fernando.proyectofinal.model.Cart;
import com.fernando.proyectofinal.model.Product;

import java.util.ArrayList;

public class CartContentActivity extends AppCompatActivity {
    private RecyclerView cartContent;

    private RecyclerView.Adapter rCAdapter;
    private RecyclerView.LayoutManager rCLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_content);

        findViews();

        Cart cart = Cart.getInstance();
        ArrayList<Product> productsInCart = cart.getProductInCart();
        cartContent.setHasFixedSize(true);
        rCLayoutManager = new LinearLayoutManager(this);
        cartContent.setLayoutManager(rCLayoutManager);
        rCAdapter = new ProductInCartAdapter(this, productsInCart);
        cartContent.setAdapter(rCAdapter);
    }

    public void findViews(){
        cartContent = (RecyclerView)findViewById(R.id.cartContentRecyclerView);
    }
}
