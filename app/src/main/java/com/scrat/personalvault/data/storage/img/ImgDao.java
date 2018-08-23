package com.scrat.personalvault.data.storage.img;

import android.content.Context;

import com.scrat.personalvault.data.storage.db.BaseDao;
import com.scrat.personalvault.data.storage.db.Db;
import com.squareup.sqlbrite3.BriteDatabase;

import java.util.List;

import io.reactivex.Observable;

import static android.database.sqlite.SQLiteDatabase.CONFLICT_NONE;

public class ImgDao extends BaseDao {
    private Context applicationContext;

    public ImgDao(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void addImg(Img img) {
        BriteDatabase db = Db.getInstance().getDb(applicationContext);
        db.insert(
                ImgEntry.TABLE,
                CONFLICT_NONE,
                ImgEntry.builder()
                        .setCreatedAt(System.currentTimeMillis())
                        .setMd5(img.md5())
                        .setSize(img.size())
                        .build()
        );
    }

    public Observable<Img> getImg(long id) {
        BriteDatabase db = Db.getInstance().getDb(applicationContext);
        String sql = "select * from " + ImgEntry.TABLE + " where " + ImgEntry.ID + "=?";
        return db.createQuery(ImgEntry.TABLE, sql, id)
                .mapToOne(ImgEntry.MAPPER);
    }

    public Observable<List<Img>> getImgList() {
        BriteDatabase db = Db.getInstance().getDb(applicationContext);
        return db.createQuery(ImgEntry.TABLE, "select * from " + ImgEntry.TABLE)
                .mapToList(ImgEntry.MAPPER);
    }

    public Observable<Integer> getTotalImg() {
        BriteDatabase db = Db.getInstance().getDb(applicationContext);
        return db.createQuery(ImgEntry.TABLE, "select count(1) from " + ImgEntry.TABLE)
                .map(INT_FUNCTION);
    }
}
