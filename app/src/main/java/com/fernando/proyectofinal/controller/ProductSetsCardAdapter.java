package com.fernando.proyectofinal.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fernando.proyectofinal.MemberStoreActivity;
import com.fernando.proyectofinal.R;
import com.fernando.proyectofinal.SetStoreActivity;
import com.fernando.proyectofinal.model.InventoryCart;
import com.fernando.proyectofinal.model.Product;
import com.fernando.proyectofinal.model.ProductSet;

import java.util.List;

/**
 * Created by Dell on 01/05/2017.
 */

public class ProductSetsCardAdapter extends RecyclerView.Adapter<ProductSetsCardAdapter.ViewHolder> {

    private List<ProductSet> productSets;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView thumbnail;
        public TextView nameTextView, descriptionTextView;
        public Button addSetButton;
        public List<Product> productSet;
        public ViewHolder(View view) {
            super(view);
            thumbnail=(ImageView) view.findViewById(R.id.thumbnail_card_product_set);
            nameTextView=(TextView)view.findViewById(R.id.name_card_product_set);
            descriptionTextView=(TextView)view.findViewById(R.id.description_card_product_set);
            addSetButton=(Button)view.findViewById(R.id.description_card_add_set_button);

        }

        public void setProductSet(List<Product> productSet) {
            this.productSet = productSet;
        }
    }

    public ProductSetsCardAdapter(Context mContext, List<ProductSet> productSets){
        //member card info contains a string list of the name and the imageid  for the user
        this.productSets = productSets;
        this.mContext=mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product_set, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ProductSet productSet = productSets.get(position);
        holder.nameTextView.setText(productSet.getName());
        holder.descriptionTextView.setText(productSet.getDescription());
        holder.thumbnail.setImageResource(productSet.getImageResourceId());

        holder.setProductSet(productSet.getProductList());
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SetStoreActivity.class);
                intent.putExtra(SetStoreActivity.PRODUCT_SET_FOUND, productSet);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        holder.addSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InventoryCart inventoryCart = InventoryCart.getInstance();
                inventoryCart.addSet(productSet.getProductList());
            }
        });

    }

    @Override
    public int getItemCount() {
        return productSets.size();
    }




}
