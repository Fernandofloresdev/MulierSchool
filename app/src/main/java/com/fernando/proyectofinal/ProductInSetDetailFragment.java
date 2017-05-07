package com.fernando.proyectofinal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fernando.proyectofinal.model.Cart;
import com.fernando.proyectofinal.model.InventoryCart;
import com.fernando.proyectofinal.model.Product;

/**
 * Created by Dell on 06/05/2017.
 */

public class ProductInSetDetailFragment extends Fragment implements View.OnClickListener{
    Product product;
    Button addToCartButton;
    public static final String ARG_ITEM = "item_id";

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        product = (Product) getArguments().getSerializable(ARG_ITEM);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.product_detail, container, false);

        if(product!=null){
            ((ImageView)rootView.findViewById(R.id.productThumbnailDetailContainer)).setImageResource(product.getImageResource());
            ((TextView)rootView.findViewById(R.id.productNameDetailContainer)).setText(product.getName());
            ((TextView)rootView.findViewById(R.id.productDescriptionDetailContainer)).setText(product.getDescription());
            ((TextView)rootView.findViewById(R.id.productPriceDetailContainer)).setText("$"+Double.toString(product.getPrice()));
            addToCartButton=(Button)rootView.findViewById(R.id.addProductDetailContainerButton);
            addToCartButton.setOnClickListener(this);
        }


        return rootView;
    }

    @Override
    public void onClick(View view) {
        Context mContext = getContext();
        switch (view.getId()){
            case R.id.addProductDetailContainerButton:
                InventoryCart cart = InventoryCart.getInstance();
                cart.addProduct(product);
                Toast.makeText(getContext(),"Added!",Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
