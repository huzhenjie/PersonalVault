package com.scrat.personalvault.data.storage.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;

import com.scrat.personalvault.data.storage.img.ImgEntry;

public class DbCallback extends SupportSQLiteOpenHelper.Callback {

    public DbCallback(int version) {
        super(Config.VERSION);
    }

    @Override
    public void onCreate(SupportSQLiteDatabase db) {
        db.execSQL(ImgEntry.CREATE_SQL);
    }

    @Override
    public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
