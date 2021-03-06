package com.fernando.proyectofinal.controller;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fernando.proyectofinal.R;
import com.fernando.proyectofinal.model.Cart;
import com.fernando.proyectofinal.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 02/05/2017.
 */

public class ProductInCartAdapter extends RecyclerView.Adapter<ProductInCartAdapter.ViewHolder>{

    private List<Product> productInCartList;
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<DataSetObserver> observers= new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView, priceTextView,quantityTextView;
        public Button plusButton, minusButton;
        public ImageButton removeButton;
        public ImageView thumbnail;
        public ViewHolder(View view) {
            super(view);
            plusButton=(Button) view.findViewById(R.id.plusProductInCartButton);
            minusButton=(Button) view.findViewById(R.id.minusProductInCartButton);
            nameTextView=(TextView)view.findViewById(R.id.nameProductInCart);
            priceTextView=(TextView)view.findViewById(R.id.priceProductInCart);
            removeButton=(ImageButton) view.findViewById(R.id.deleteProductInCartButton);
            quantityTextView=(TextView)view.findViewById(R.id.quantityProductInCart);
            thumbnail=(ImageView)view.findViewById(R.id.productThumbnailInCart);

        }
    }

    public ProductInCartAdapter(Context mContext, List<Product> productInCartList){
        //member card info contains a string list of the name and the imageid  for the user
        this.productInCartList = productInCartList;
        this.mContext=mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_in_cart, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Product product = productInCartList.get(position);
        holder.nameTextView.setText(product.getName());
        holder.priceTextView.setText("$"+ Double.toString(product.getPrice()));
        holder.quantityTextView.setText(Integer.toString(product.getQuantity()));
        holder.thumbnail.setImageResource(product.getImageResource());

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart = Cart.getInstance();
                cart.addProduct(product);
                holder.quantityTextView.setText(Integer.toString(product.getQuantity()));
                dataSetChanged();
            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart = Cart.getInstance();
                if(product.getQuantity()>1){
                    cart.subtractProduct(position);
                    holder.quantityTextView.setText(Integer.toString(product.getQuantity()));
                }else{
                    cart.remove(position);
                }
                dataSetChanged();
            }
        });
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart = Cart.getInstance();
                cart.remove(position);
                dataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return productInCartList.size();
    }

    public void registerDataSetObserver(DataSetObserver observer){
        observers.add(observer);
    }

    public void dataSetChanged(){
        notifyDataSetChanged();
        for(DataSetObserver observer: observers){
            observer.onChanged();
        }
    }

}
