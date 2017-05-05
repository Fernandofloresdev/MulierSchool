package com.fernando.proyectofinal;

import android.content.Intent;
import android.media.midi.MidiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fernando.proyectofinal.controller.OrderAdapter;
import com.fernando.proyectofinal.model.Order;

import java.util.ArrayList;

public class CheckOrdersActivity extends AppCompatActivity {
    public static final String ORDERS_FOUND = "ordersFound";
    private ArrayList<Order> orderList;
    private RecyclerView ordersRecyclerView;
    private RecyclerView.Adapter rCAdapter;
    private RecyclerView.LayoutManager rCLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_orders);

        Intent intent = getIntent();
        orderList = (ArrayList<Order>) intent.getSerializableExtra(ORDERS_FOUND);

        findViews();
        rCAdapter = new OrderAdapter(this, orderList);
        ordersRecyclerView.setHasFixedSize(true);
        rCLayoutManager = new LinearLayoutManager(this);
        ordersRecyclerView.setLayoutManager(rCLayoutManager);
        ordersRecyclerView.setAdapter(rCAdapter);

    }

    public void findViews(){
        ordersRecyclerView=(RecyclerView)findViewById(R.id.ordersRecyclerView);
    }
}
