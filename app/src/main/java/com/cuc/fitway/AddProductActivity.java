package com.cuc.fitway;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {

    EditText name, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        setTitle("Add products");
        name = findViewById(R.id.text_input_product_name);
        description = findViewById(R.id.text_input_product_description);
    }

    public void addProduct(View view) {
        ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this, "bd_fitway", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("product_name", name.getText().toString());
        values.put("product_description", description.getText().toString());
        db.insert("products", "id", values);
        finish();
    }


}