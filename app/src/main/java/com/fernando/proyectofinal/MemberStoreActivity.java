package com.fernando.proyectofinal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fernando.proyectofinal.controller.ProductGridObjectAdapter;
import com.fernando.proyectofinal.controller.ProductSetSelectorAdapter;
import com.fernando.proyectofinal.model.DummyTest;
import com.fernando.proyectofinal.model.GridSpacingItemDecoration;
import com.fernando.proyectofinal.model.MemberStore;
import com.fernando.proyectofinal.model.Product;
import com.fernando.proyectofinal.model.ProductSet;

import java.util.ArrayList;
import java.util.List;

public class MemberStoreActivity extends AppCompatActivity {

    MemberStore memberStore;
    RecyclerView productsRecyclerView;
    private RecyclerView.Adapter rCAdapter;
    private RecyclerView.LayoutManager rCLayoutManager;
    private FloatingActionButton fab;
    private List<Product> productList;
    public static final String MEMBER_STORE_FOUND = "memberStoreFound";
    public static final String PRODUCT_SET_FOUND = "productSetFound";
    public static final String MEMBER_CARD_SELECTED = "memberCardSelected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_store);


        Intent intent = getIntent();
        if(intent.hasExtra(MEMBER_STORE_FOUND)){
            memberStore = (MemberStore) intent.getSerializableExtra(MEMBER_STORE_FOUND);
            productList = new DummyTest().getProducts();
            rCAdapter = new ProductGridObjectAdapter(this, productList);
        }else if(intent.hasExtra(PRODUCT_SET_FOUND)){
            ProductSet productSet = (ProductSet)intent.getSerializableExtra(PRODUCT_SET_FOUND);
            productList = productSet.getProductList();
            rCAdapter = new ProductSetSelectorAdapter(this, productList);
        }else if(intent.hasExtra(MEMBER_CARD_SELECTED)){
            memberStore = (MemberStore) intent.getSerializableExtra(MEMBER_CARD_SELECTED);
            rCAdapter = new ProductGridObjectAdapter(this, memberStore.getProducts());
        }


        findViews();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CartContentActivity.class);
                startActivity(intent);
            }
        });


        int spacingInPixels = 15;



        productsRecyclerView.setHasFixedSize(true);
        rCLayoutManager = new GridLayoutManager(this, 2);
        productsRecyclerView.setLayoutManager(rCLayoutManager);
        productsRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spacingInPixels));
        productsRecyclerView.setAdapter(rCAdapter);
    }

    public void findViews() {
        productsRecyclerView = (RecyclerView) findViewById(R.id.productsRecyclerView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }


    }

