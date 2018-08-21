package com.scrat.personalvault.data.storage.db;

import android.database.Cursor;

public class BaseEntry {
    public static final int BOOLEAN_FALSE = 0;
    public static final int BOOLEAN_TRUE = 1;
    protected static final String PRIMARY_KEY = " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT";
    protected static final String TEXT = " TEXT NOT NULL DEFAULT ''";
    protected static final String NUMBER = " INTEGER NOT NULL DEFAULT 0";
    protected static final String UNIQUE = " UNIQUE";

    public static String getString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndexOrThrow(columnName));
    }

    public static boolean getBoolean(Cursor cursor, String columnName) {
        return getInt(cursor, columnName) == BOOLEAN_TRUE;
    }

    public static long getLong(Cursor cursor, String columnName) {
        return cursor.getLong(cursor.getColumnIndexOrThrow(columnName));
    }

    public static int getInt(Cursor cursor, String columnName) {
        return cursor.getInt(cursor.getColumnIndexOrThrow(columnName));
    }

}