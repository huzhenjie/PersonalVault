package com.scrat.personalvault.data.storage.img;

import android.content.ContentValues;
import android.database.Cursor;

import com.scrat.personalvault.data.storage.db.BaseEntry;

import io.reactivex.functions.Function;

public class ImgEntry extends BaseEntry {

    private static final String TABLE = "img";

    private static final String ID = "_id";
    private static final String SIZE = "size";
    private static final String IMG_NAME = "img_name";
    private static final String CREATED_AT = "created_at";
    private static final String UPDATE_AT = "update_at";
    private static final String MD5 = "md5";

    public static final String CREATE_SQL = "create table " + TABLE + "("
            + ID + PRIMARY_KEY + ","
            + IMG_NAME + TEXT + ","
            + SIZE + NUMBER + ","
            + CREATED_AT + NUMBER + ","
            + UPDATE_AT + NUMBER + ","
            + MD5 + TEXT + ")";

    public static final Function<Cursor, Img> MAPPER = cursor -> {
        long id = getLong(cursor, ID);
        long size = getLong(cursor, SIZE);
        String imgName = getString(cursor, IMG_NAME);
        long createdAt = getLong(cursor, CREATED_AT);
        long updateAt = getLong(cursor, UPDATE_AT);
        String md5 = getString(cursor, MD5);
        return new AutoValue_Img(id, size, imgName, createdAt, updateAt, md5);
    };

    private ImgEntry() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final ContentValues values = new ContentValues();

        public Builder setId(long id) {
            values.put(ID, id);
            return this;
        }

        public Builder setSize(long size) {
            values.put(SIZE, size);
            return this;
        }

        public Builder setCreatedAt(long createdAt) {
            values.put(CREATED_AT, createdAt);
            return this;
        }

        public Builder setUpdateAt(long updateAt) {
            values.put(UPDATE_AT, updateAt);
            return this;
        }

        public Builder setMd5(String md5) {
            values.put(MD5, md5);
            return this;
        }

        public ContentValues build() {
            return values;
        }
    }
}
