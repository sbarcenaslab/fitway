package com.cuc.fitway.utils;

public class Utils {
    public static final String ADD_USER_TABLE = "CREATE TABLE users (id INTEGER, first_name TEXT, last_name TEXT, nice_name TEXT unique, rol TEXT, updated_at TEXT, deleted_at TEXT)";
    public static final String ADD_USER_DETAIL_TABLE = "CREATE TABLE users_detail (id INTEGER, phone TEXT, address TEXT, email TEXT, user_id INTEGER)";
    public static final String ADD_COMMENTS_TABLE = "CREATE TABLE comments (id INTEGER, title TEXT, product_id INTEGER, user_id INTEGER)";
    public static final String ADD_PRODUCTS_TABLE = "CREATE TABLE products (id INTEGER, product_name TEXT, product_description TEXT)";
    public static final String ADD_RATES_TABLE = "CREATE TABLE rates (id INTEGER, product_id INTEGER, value INTEGER)";
}
