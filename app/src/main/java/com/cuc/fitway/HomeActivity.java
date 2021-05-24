package com.cuc.fitway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.cuc.fitway.entities.Products;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<Products> products = new ArrayList<Products>();
    RecyclerView recycler;
    private final static String QUERY = "SELECT * FROM products" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recycler = (RecyclerView) findViewById(R.id.recycler_id);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        String[] fields = {"id", "name", "description"};
        ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this, "bd_fitway", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor= db.rawQuery(QUERY,null);

        while(cursor.moveToNext()) {
            String name =  cursor.getString(1);
            String description =  cursor.getString(2);
            Products product = new Products(1, name, description);
            products.add(product);
        }

        cursor.close();



        AdapterProduct adapterProduct = new AdapterProduct(products);
        recycler.setAdapter(adapterProduct);
    }

    public void onBuy(View view) {
        Intent intent = new Intent(this, ThanksActivity.class);
        startActivity(intent);
    }



}