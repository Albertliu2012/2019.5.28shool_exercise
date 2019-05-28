package com.example.administrator.databasehelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2019/5/28.
 */

public class DbHelper extends SQLiteOpenHelper {

    public final String sql = "create table class ("
            + "_id integer primary key autoincrement"
            + ", name varchar(64)"
            + ", number varchar(64))";

    public DbHelper(Context context) {
        super(context, "text.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
