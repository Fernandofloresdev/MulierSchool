package com.fernando.proyectofinal.controller;

/**
 * Created by Dell on 01/05/2017.
 */

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

import com.fernando.proyectofinal.ProductDetailActivity;
import com.fernando.proyectofinal.ProductDetailFragment;
import com.fernando.proyectofinal.ProductInSetDetailActivity;
import com.fernando.proyectofinal.ProductInSetDetailFragment;
import com.fernando.proyectofinal.R;
import com.fernando.proyectofinal.model.InventoryCart;
import com.fernando.proyectofinal.model.MemberStore;
import com.fernando.proyectofinal.model.Product;

import java.util.List;

/**
 * Created by Dell on 01/05/2017.
 */
public class ProductSetSelectorAdapter extends RecyclerView.Adapter<ProductSetSelectorAdapter.ViewHolder> {

    private List<Product> productList;
    private Context mContext;
    private LayoutInflater inflater;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView nameTextView, priceTextView;
        public Button addToCartButton;
        private String name, description;
        private double price;
        private int id, imageResource, availability, quantity;

        public ViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.productThumbnailGridObject);
            nameTextView = (TextView) view.findViewById(R.id.productNameGridObject);
            priceTextView = (TextView) view.findViewById(R.id.productPriceGridObject);
            addToCartButton = (Button) view.findViewById(R.id.addProductGridObjectButton);
        }

        public Product packProduct() {
            return new Product(id, name, description, price, imageResource, availability);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setImageResource(int imageResource) {
            this.imageResource = imageResource;
        }

        public void setAvailability(int availability) {
            this.availability = availability;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public ProductSetSelectorAdapter(Context mContext, List<Product> productList) {
        //member card info contains a string list of the name and the imageid  for the user
        this.productList = productList;
        this.mContext = mContext;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_grid_object, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Product product = productList.get(position);
        holder.nameTextView.setText(product.getName());
        holder.priceTextView.setText("$" + Double.toString(product.getPrice()));
        holder.thumbnail.setImageResource(product.getImageResource());
        holder.addToCartButton.setText("Add to my store");

        //giving values to the holder
        holder.setImageResource(product.getImageResource());
        holder.setPrice(product.getPrice());
        holder.setDescription(product.getDescription());
        holder.setName(product.getName());
        holder.setId(product.getId());

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = holder.packProduct();
                Intent intent = new Intent(mContext, ProductInSetDetailActivity.class);
                intent.putExtra(ProductInSetDetailFragment.ARG_ITEM, product);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InventoryCart car = InventoryCart.getInstance();
                car.addProduct(product);
                Toast.makeText(mContext,"Added to Inventory",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
