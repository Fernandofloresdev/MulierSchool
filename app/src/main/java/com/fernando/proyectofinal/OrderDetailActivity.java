package com.fernando.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fernando.proyectofinal.AsyncTask.AcceptOrderTask;
import com.fernando.proyectofinal.controller.OrderDetailAdapter;
import com.fernando.proyectofinal.controller.ProductInCartAdapter;
import com.fernando.proyectofinal.model.Order;
import com.fernando.proyectofinal.model.Product;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {


    private RecyclerView productsInOrder;
    private RecyclerView.Adapter rCAdapter;
    private RecyclerView.LayoutManager rCLayoutManager;
    private ArrayList<Product> products;
    private Order order;
    private Button acceptButton, denyButton;
    public static final String ORDER_RECEIVED="order_received";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail_activity);

        Intent intent = getIntent();
        order = (Order) intent.getSerializableExtra(ORDER_RECEIVED);
        products=order.getProductOrder();

        findViews();


        productsInOrder.setHasFixedSize(true);
        rCLayoutManager = new LinearLayoutManager(this);
        productsInOrder.setLayoutManager(rCLayoutManager);
        rCAdapter = new OrderDetailAdapter(order,this);
        productsInOrder.setAdapter(rCAdapter);


    }

    public void findViews(){
        productsInOrder=(RecyclerView)findViewById(R.id.recycler_in_order_detail);
        acceptButton=(Button)findViewById(R.id.acceptButton);
        denyButton=(Button)findViewById(R.id.denyButton);
    }

    public void acceptButtonAction(View view){
        AcceptOrderTask acceptOrderTask=new AcceptOrderTask(this);
        acceptOrderTask.execute(order);
    }

    public void denyButtonAction(View view){
        Toast.makeText(this, "Esto eliminara la orden", Toast.LENGTH_SHORT).show();
    }
}
