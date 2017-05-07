package com.fernando.proyectofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dell on 06/05/2017.
 */

public class ProductInSetDetailActivity extends AppCompatActivity {
    public final String item_id = "item_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);


        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putSerializable(ProductInSetDetailFragment.ARG_ITEM, getIntent().getSerializableExtra(ProductInSetDetailFragment.ARG_ITEM));
            ProductInSetDetailFragment fragment = new ProductInSetDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.product_detail_container, fragment)
                    .commit();
        }

    }
}
