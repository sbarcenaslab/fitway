package com.cuc.fitway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nice_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nice_name= findViewById(R.id.text_input_product_name);
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void onLogin(View view) {
        try {
            Toast.makeText(getBaseContext(), "Reason can not be blank", Toast.LENGTH_SHORT).show();
            ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this, "bd_fitway", null, 1);
            SQLiteDatabase db = conn.getReadableDatabase();
            String[] parameters = {nice_name.getText().toString()};
            String[] fields = {"rol"};
            Cursor cursor = db.query("users", fields, "nice_name=?", parameters, null, null, null);
            cursor.moveToFirst();
            ((TextView) findViewById(R.id.textView3)).setText(cursor.getString(0));
            if(cursor.getString(0).equals("admin")){
                Intent intent = new Intent(this, AdminHomeActivity.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Reason can not be blank", Toast.LENGTH_SHORT).show();

            } else {

                Intent intent = new Intent(this, HomeActivity.class);
                Toast.makeText(getBaseContext(), "Reason can not be blank", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            cursor.close();
        }catch (Exception e) {
            ((TextView) findViewById(R.id.textView3)).setText( e.toString());
            Toast.makeText(getBaseContext(), "Reason can not be blank", Toast.LENGTH_SHORT).show();
        }

    }


}