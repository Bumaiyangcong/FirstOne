package com.bumaiyangcong.demo1_createdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pange on 公元17-06-27.
 */

public class MySqliteOpenHelper extends SQLiteOpenHelper{
    //context :上下文   ， name：数据库文件的名称    factory：用来创建cursor对象，默认为null
    //version:数据库的版本号，从1开始，如果发生改变，onUpgrade方法将会调用,4.0之后只能升不能将

    public MySqliteOpenHelper(Context context) {
        super(context, "info.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table info(_id increment,name varchar(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table info add phone varchar(11)");
    }
}
