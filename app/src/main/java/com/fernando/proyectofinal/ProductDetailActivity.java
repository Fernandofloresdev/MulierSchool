package com.fernando.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProductDetailActivity extends AppCompatActivity {
    public final String item_id = "item_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);


        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putSerializable(ProductDetailFragment.ARG_ITEM, getIntent().getSerializableExtra(ProductDetailFragment.ARG_ITEM));
            ProductDetailFragment fragment = new ProductDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.product_detail_container, fragment)
                    .commit();
        }

    }
}
