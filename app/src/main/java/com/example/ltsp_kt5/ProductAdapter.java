package com.example.ltsp_kt5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter {

    Activity activity;

    public ProductAdapter(Activity activity, ArrayList products) {
        super(activity,0, products);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = this.activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.product_item,null);

        }

        TextView productName = convertView.findViewById(R.id.name);
        TextView productPrice = convertView.findViewById(R.id.price);
        TextView productUnit = convertView.findViewById(R.id.unit);

        ArrayList<Product> products = Product.getProducts();

        Product product = products.get(position);

        productName.setText(product.getName());
        productPrice.setText((String)(new DecimalFormat("#,###.##")).format(product.getPrice()));
        productUnit.setText(product.getUnit());


        return convertView;
    }
}
