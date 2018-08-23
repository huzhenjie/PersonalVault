package com.scrat.personalvault.data.storage.db;

import android.database.Cursor;

import com.squareup.sqlbrite3.SqlBrite;

import io.reactivex.functions.Function;

public class BaseDao {
    public static Function<SqlBrite.Query, Integer> INT_FUNCTION = query -> {
        Cursor cursor = query.run();
        if (cursor == null) {
            return 0;
        }
        try {
            if (!cursor.moveToNext()) {
                throw new AssertionError("No rows");
            }
            return cursor.getInt(0);
        } finally {
            cursor.close();
        }
    };

    public static Function<SqlBrite.Query, String> STRING_FUNCTION = query -> {
        Cursor cursor = query.run();
        if (cursor == null) {
            return "";
        }
        try {
            if (!cursor.moveToNext()) {
                throw new AssertionError("No rows");
            }
            return cursor.getString(0);
        } finally {
            cursor.close();
        }
    };
}
