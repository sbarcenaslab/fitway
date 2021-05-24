package com.cuc.fitway;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.cuc.fitway.utils.Utils;

public class ConnectionSQLiteHelper extends SQLiteOpenHelper {

    public ConnectionSQLiteHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utils.ADD_USER_TABLE);
        db.execSQL(Utils.ADD_USER_DETAIL_TABLE);
        db.execSQL(Utils.ADD_PRODUCTS_TABLE);
        db.execSQL(Utils.ADD_COMMENTS_TABLE);
        db.execSQL(Utils.ADD_RATES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS users_detail");
        db.execSQL("DROP TABLE IF EXISTS comments");
        db.execSQL("DROP TABLE IF EXISTS products");
        db.execSQL("DROP TABLE IF EXISTS rates");
        db.execSQL(Utils.ADD_USER_TABLE);
        db.execSQL(Utils.ADD_USER_DETAIL_TABLE);
        db.execSQL(Utils.ADD_PRODUCTS_TABLE);
        db.execSQL(Utils.ADD_COMMENTS_TABLE);
        db.execSQL(Utils.ADD_RATES_TABLE);
    }
}
