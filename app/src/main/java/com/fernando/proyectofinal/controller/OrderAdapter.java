package com.fernando.proyectofinal.controller;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fernando.proyectofinal.R;
import com.fernando.proyectofinal.model.Order;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by Dell on 02/05/2017.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{
    ArrayList<Order> orderList;
    private Context mContext;

    public OrderAdapter(Context mContext, ArrayList<Order> orderList){
        this.mContext=mContext;
        this.orderList=orderList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_in_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Order order = orderList.get(position);

        holder.memberName.setText(order.getMember().getName());
        Double price =order.getTotalPrice();
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        holder.priceDisplay.setText("$"+numberFormat.format(price));
        holder.thumbnail.setImageResource(order.getMember().getImageResource());
        holder.acceptOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Accept Order ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView memberName, priceDisplay;
        ImageView thumbnail;
        Button acceptOrderButton;

        public ViewHolder(View itemView) {
            super(itemView);
            memberName=(TextView)itemView.findViewById(R.id.memberNameDisplayInOrderList);
            priceDisplay=(TextView)itemView.findViewById(R.id.totalPriceDisplayInOrderList);
            thumbnail=(ImageView)itemView.findViewById(R.id.thumbnailDisplayInOrderList);
            acceptOrderButton=(Button)itemView.findViewById(R.id.aceptOrderInListButton);
        }
    }
}