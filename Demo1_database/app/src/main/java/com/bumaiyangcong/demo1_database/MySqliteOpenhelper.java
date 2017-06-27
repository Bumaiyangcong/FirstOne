package com.bumaiyangcong.demo1_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pange on 公元17-06-26.
 * 创建数据库步骤：
 1.创建一个类集成SqliteOpenHelper，需要添加一个构造方法，实现两个方法oncreate ,onupgrade
 构造方法中的参数介绍：
 //context :上下文   ， name：数据库文件的名称    factory：用来创建cursor对象，默认为null
 //version:数据库的版本号，从1开始，如果发生改变，onUpgrade方法将会调用,4.0之后只能升不能将
 super(context, "info.db", null,1);
 2.创建这个帮助类的一个对象，调用getReadableDatabase()方法，会帮助我们创建打开一个数据库
 3.复写oncreate和onupgrdate方法：
 oncreate方法是数据库第一次创建的时候会被调用;  特别适合做表结构的初始化,需要执行sql语句；
 SQLiteDatabase db可以用来执行sql语句
 //onUpgrade数据库版本号发生改变时才会执行； 特别适合做表结构的修改
 */

public class MySqliteOpenhelper extends SQLiteOpenHelper {
    public MySqliteOpenhelper(Context context) {
        super(context, "info.db", null, 1);
    }


//
    @Override
    public void onCreate(SQLiteDatabase db) {
        //通过sqlitedatabase执行一个创建表的sql语句
    db.execSQL("create table info(_id integer primary key autoincrement,name varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //添加一个phone字段
        db.execSQL("alter table info add phone varchar(11)");

    }
}
