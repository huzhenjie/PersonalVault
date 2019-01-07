package com.scrat.personalvault.data.storage.db;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Factory;
import android.arch.persistence.db.framework.FrameworkSQLiteOpenHelperFactory;
import android.content.Context;

import com.scrat.lib.uitl.L;
import com.squareup.sqlbrite3.BriteDatabase;
import com.squareup.sqlbrite3.SqlBrite;

import io.reactivex.schedulers.Schedulers;

public class Db {
    public static final int VERSION = 1;
    public static final String DB_NAME = "vault";

    private static class SingletonHolder {
        private static Db instance = new Db();
    }

    public static Db getInstance() {
        return SingletonHolder.instance;
    }

    private BriteDatabase db;

    private Db() {

    }

    private void init(Context applicationContext) {
        SqlBrite sqlBrite = new SqlBrite.Builder()
                .logger(message -> L.d("[db] %s", message))
                .build();
        Configuration configuration = Configuration.builder(applicationContext)
                .name(DB_NAME)
                .callback(new DbCallback(VERSION))
                .build();
        Factory factory = new FrameworkSQLiteOpenHelperFactory();
        SupportSQLiteOpenHelper helper = factory.create(configuration);
        db = sqlBrite.wrapDatabaseHelper(helper, Schedulers.io());
        db.setLoggingEnabled(true);
    }

    public BriteDatabase getDb(Context applicationContext) {
        if (db == null) {
            init(applicationContext);
        }
        return db;
    }
}
