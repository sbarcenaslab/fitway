package com.cuc.fitway;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.cuc.fitway.entities.Products;


import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolderData>{

    ArrayList<Products> products;

    public AdapterProduct(ArrayList<Products> products) {
        this.products = products;
    }

    @Override
    public AdapterProduct.ViewHolderData onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list, null, false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder( AdapterProduct.ViewHolderData holder, int position) {
        holder.assignData(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        TextView name, description;
        Button button;

        public ViewHolderData(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById((R.id.product_name));
            description = (TextView) itemView.findViewById((R.id.product_description));
            button = itemView.findViewById(R.id.button3);
        }

        public void assignData(Products product) {
            name.setText(product.getName());
            description.setText(product.getDescription());
        }


    }
}
