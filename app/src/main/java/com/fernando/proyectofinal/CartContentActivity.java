package com.fernando.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.fernando.proyectofinal.AsyncTask.OrderTask;
import com.fernando.proyectofinal.controller.ProductInCartAdapter;
import com.fernando.proyectofinal.model.Cart;
import com.fernando.proyectofinal.model.Product;

import java.util.ArrayList;

public class CartContentActivity extends AppCompatActivity {
    private RecyclerView cartContent;

    private RecyclerView.Adapter rCAdapter;
    private RecyclerView.LayoutManager rCLayoutManager;
    ArrayList<Product> productsInCart;
    Button orderButton;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_content);


        findViews();

        Cart cart = Cart.getInstance();
        productsInCart = cart.getProductInCart();
        cartContent.setHasFixedSize(true);
        rCLayoutManager = new LinearLayoutManager(this);
        cartContent.setLayoutManager(rCLayoutManager);
        rCAdapter = new ProductInCartAdapter(this, productsInCart);
        cartContent.setAdapter(rCAdapter);
    }

    public void findViews(){
        cartContent = (RecyclerView)findViewById(R.id.cartContentRecyclerView);
        orderButton=(Button)findViewById(R.id.orderButton);
    }

    public void order(View view){
        OrderTask orderTask=new OrderTask(this);
        orderTask.execute(productsInCart);

    }
}
