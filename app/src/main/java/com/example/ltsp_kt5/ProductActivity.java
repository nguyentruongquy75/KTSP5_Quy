package com.example.ltsp_kt5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    Intent intent;
    EditText productName, productPrice, productUnit;
    Button btnOK, btnCancel;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Product Edit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productName = findViewById(R.id.editnamexml);
        productPrice = findViewById(R.id.editpricexml);
        productUnit = findViewById(R.id.editunitxml);

        btnOK = findViewById(R.id.btnOK);
        btnCancel = findViewById(R.id.btnCancel);

        intent = getIntent();
        productAdapter = new ProductAdapter(this, Product.getProducts());
        Integer position = intent.getIntExtra("position",0);

        ArrayList<Product> products = Product.getProducts();
        Product product = products.get(position);


        productName.setText(product.getName());
        productPrice.setText(product.getPrice() + "");
        productUnit.setText(product.getUnit());

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setUnit(productUnit.getText().toString());
                product.setName(productName.getText().toString());
                product.setPrice(Integer.parseInt(productPrice.getText().toString()));

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                productAdapter.notifyDataSetChanged();

                finish();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;


            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}