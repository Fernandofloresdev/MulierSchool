package com.fernando.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fernando.proyectofinal.controller.ProductSetsCardAdapter;
import com.fernando.proyectofinal.model.Product;
import com.fernando.proyectofinal.model.ProductSet;

import java.util.ArrayList;
import java.util.List;

public class CreateStoreActivity extends AppCompatActivity {

    private RecyclerView productSetRecyclerView;
    private RecyclerView.Adapter rCAdapter;
    private RecyclerView.LayoutManager rCLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_store);

        findViews();

        ArrayList<ProductSet> productSets = getProductSets();

        productSetRecyclerView.setHasFixedSize(true);
        rCLayoutManager = new LinearLayoutManager(this);
        productSetRecyclerView.setLayoutManager(rCLayoutManager);
        rCAdapter = new ProductSetsCardAdapter(this, productSets);
        productSetRecyclerView.setAdapter(rCAdapter);
    }

    public ArrayList<ProductSet> getProductSets(){
        ArrayList<ProductSet> productSetArrayList=new ArrayList<>();
        ArrayList<Product> products =new ArrayList<>();
        products.add(new Product(6, "bag6", "bag6", 15.2, R.drawable.bag6, 0));
        productSetArrayList.add(new ProductSet(products,"Bag Set", " a set of beautfitul bags",R.drawable.bag4));

        return productSetArrayList;
    }

    private void findViews(){
        productSetRecyclerView=(RecyclerView)findViewById(R.id.product_sets_recycler_view);
    }
}
