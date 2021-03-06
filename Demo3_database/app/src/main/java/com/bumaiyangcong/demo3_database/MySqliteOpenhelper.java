package com.bumaiyangcong.demo3_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pange on 公元17-06-27.
 */

public class MySqliteOpenhelper extends SQLiteOpenHelper {
    public MySqliteOpenhelper(Context context) {
        super(context, "info.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table info(_id integer primary key autoincrement,name varchar(20),phone varchar(11))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table info add phone varchar(11)");
    }
}
