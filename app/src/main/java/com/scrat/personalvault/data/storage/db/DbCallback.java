package com.scrat.personalvault.data.storage.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;

import com.scrat.lib.uitl.L;
import com.scrat.personalvault.data.storage.img.ImgEntry;

public class DbCallback extends SupportSQLiteOpenHelper.Callback {

    public DbCallback(int version) {
        super(version);
    }

    @Override
    public void onCreate(SupportSQLiteDatabase db) {
        L.i("[DB] create table");
        db.execSQL(ImgEntry.CREATE_SQL);
    }

    @Override
    public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
        L.i("[DB] oldVersion=%s newVersion=%s", oldVersion, newVersion);
    }
}
