package com.fernando.proyectofinal.controller;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fernando.proyectofinal.R;
import com.fernando.proyectofinal.model.Order;
import com.fernando.proyectofinal.model.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 04/05/2017.
 */

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder>{

    private ArrayList<Product> productsInOrder;
    private Order order;
    private Context mContext;

    public OrderDetailAdapter(Order order, Context mContext) {
        this.order=order;
        this.mContext = mContext;
        productsInOrder= order.getProductOrder();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_detail_in_order, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        productsInOrder= order.getProductOrder();
        Product product= productsInOrder.get(position);
        holder.thumbnail.setImageResource(product.getImageResource());
        holder.name.setText(product.getName());
        DecimalFormat format = new DecimalFormat("#.00");
        holder.price.setText(format.format(product.getPrice()));
        holder.quantity.setText(Integer.toString(product.getQuantity()));
        Double totalPrice=product.getPrice()*product.getQuantity();
        holder.totalPrice.setText(format.format(totalPrice));

    }

    @Override
    public int getItemCount() {
        return productsInOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView name,price,quantity,totalPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail=(ImageView)itemView.findViewById(R.id.thumbnail_in_order_detail);
            name=(TextView)itemView.findViewById(R.id.product_name_in_order_detail);
            price=(TextView)itemView.findViewById(R.id.product_price_in_order_detail);
            quantity=(TextView)itemView.findViewById(R.id.product_quantity_in_order_detail);
            totalPrice=(TextView)itemView.findViewById(R.id.total_price_in_order_detail);

        }
    }
}
