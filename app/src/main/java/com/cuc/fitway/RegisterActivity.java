package com.cuc.fitway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    EditText firstName, lastName, niceName, email, phone, address;
    Switch isAdmin;
    TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        niceName = findViewById(R.id.nicename);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        mainText = findViewById(R.id.textView);
        isAdmin = findViewById(R.id.adminSwitch);
    }

    public void onRegister(View view) {

        try {
            ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this, "bd_fitway", null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("first_name", firstName.getText().toString());
            values.put("last_name", lastName.getText().toString());
            values.put("nice_name", niceName.getText().toString());
            values.put("rol", "admin");
            Long id  = db.insert("users", "id", values);
            ContentValues valuesDetail = new ContentValues();
            valuesDetail.put("email", email.getText().toString());
            valuesDetail.put("address", address.getText().toString());
            valuesDetail.put("phone", phone.getText().toString());
            valuesDetail.put("user_id", id);

            boolean isChecked = isAdmin.isChecked();
            if(isChecked) {
                valuesDetail.put("rol", "admin");
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("user_id", id );
                startActivity(intent);
            } else {
                valuesDetail.put("rol", "user");
                Intent intent = new Intent(this, AdminHomeActivity.class);
                intent.putExtra("user_id", id );
                startActivity(intent);
            }
        } catch (Exception e) {
            mainText.setText(e.toString());
            Toast.makeText(this, "Register error, please try again", Toast.LENGTH_SHORT).show();

        }
    }
}