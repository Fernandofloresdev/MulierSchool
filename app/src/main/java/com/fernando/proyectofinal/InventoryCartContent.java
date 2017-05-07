package com.fernando.proyectofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fernando.proyectofinal.AsyncTask.OrderTask;
import com.fernando.proyectofinal.AsyncTask.addSetTask;
import com.fernando.proyectofinal.controller.ProductInCartAdapter;
import com.fernando.proyectofinal.model.Cart;
import com.fernando.proyectofinal.model.InventoryCart;
import com.fernando.proyectofinal.model.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Dell on 06/05/2017.
 */

public class InventoryCartContent extends AppCompatActivity {
    private RecyclerView cartContent;
    private RecyclerView.Adapter rCAdapter;
    private RecyclerView.LayoutManager rCLayoutManager;
    ArrayList<Product> productsInCart;
    public TextView priceDisplay;
    Button orderButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_content);


        findViews();

        InventoryCart cart = InventoryCart.getInstance();
        productsInCart = cart.getProductInCart();
        cartContent.setHasFixedSize(true);
        rCLayoutManager = new LinearLayoutManager(this);
        cartContent.setLayoutManager(rCLayoutManager);
        rCAdapter = new ProductInCartAdapter(this, productsInCart);
        cartContent.setAdapter(rCAdapter);
        updatePrice();
    }

    public void findViews(){
        cartContent = (RecyclerView)findViewById(R.id.cartContentRecyclerView);
        orderButton=(Button)findViewById(R.id.orderButton);
        priceDisplay =(TextView) findViewById(R.id.totalPriceDisplayInCart);
    }

    public void order(View view){
        addSetTask orderTask=new addSetTask(this);
        orderTask.execute(productsInCart);
        InventoryCart cart = InventoryCart.getInstance();
        cart.clear();
    }

    public void updatePrice(){
        InventoryCart cart = InventoryCart.getInstance();
        priceDisplay.setText("$"+ Double.toString(cart.getTotalSum()));

        cartContent.getAdapter().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                InventoryCart cart = InventoryCart.getInstance();
                Double price =cart.getTotalSum();
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                priceDisplay.setText("$"+numberFormat.format(price));
            }
        });
    }




}