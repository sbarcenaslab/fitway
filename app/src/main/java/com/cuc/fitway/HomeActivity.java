package com.cuc.fitway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.cuc.fitway.entities.Products;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<Products> products = new ArrayList<Products>();
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this, "bd_fitway", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] fields = {"id", "name", "description"};
        Cursor cursor = db.query("products", fields, null, null, null, null, null);

        while(cursor.moveToNext()) {
            int id =  Integer.parseInt(cursor.getString(0));
            int name =  Integer.parseInt(cursor.getString(0));
            int description =  Integer.parseInt(cursor.getString(0));

            new Products()
        }

        recycler = (RecyclerView) findViewById(R.id.recycler_id);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}