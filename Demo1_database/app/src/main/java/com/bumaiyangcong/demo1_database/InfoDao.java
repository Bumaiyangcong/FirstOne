package com.bumaiyangcong.demo1_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pange on 公元17-06-26.
 */

public class InfoDao {
    private MySqliteOpenhelper mySqliteOpenhelper;

    public InfoDao(Context context) {
        //创建一个帮助类对象
        mySqliteOpenhelper = new MySqliteOpenhelper(context);
    }

    public void add(InfoBean bean) {
        //执行sql语句需要sqlitedatabase对象
        //调用getreadabledatabase方法来初始化数据库的创建
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        //sql:sql语句     bindArgs:sql语句中占位符的值
        db.execSQL("insert into info(name,phone)values(?,?)", new Object[]{bean.name, bean.phone});
        //关闭数据库对象
        db.close();
    }

    public void delete(String name) {
        //执行sql语句需要sqlitedatabase对象
        //调用getreadabledatabase方法来初始化数据库的创建
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        //sql:sql语句 bindArgs:sql语句中占位符的值
        db.execSQL("delete from info where name=?;", new Object[]{name});
        //关闭数据库对象
        db.close();
    }

    public void update(InfoBean bean) {
        //执行sql语句需要sqlitedatabase对象
        //调用getreadabledatabase方法来初始化数据库的创建
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        //sql:sql语句 bindArgs:sql语句中占位符的值
        db.execSQL("update into info set phone=? where name =?;", new Object[]{bean.name, bean.phone});
        //关闭数据库对象
        db.close();
    }

    public void query(String name) {
        //执行sql语句需要sqlitedatabase对象
        //调用getreadabledatabase方法来初始化数据库的创建
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        //sql:sql语句 bindArgs:sql语句中占位符的值
        Cursor cursor = db.rawQuery("select _id,name,phone from info where name=?;", new String[]{});
        //解析cursor中的数据
        if (cursor != null && cursor.getCount() > 0) {//判断cursor 中是否存在数据
            //循环遍历结果集，获取每一行的内容
            while (cursor.moveToNext()) {//条件，游标能否定位到下一行
                //获取数据
                int id = cursor.getInt(0);
                String name_str=cursor.getString(1);
                String phone =cursor.getString(2);
                System.out.println("_id:"+id+";name:"+name_str+";phone:"+phone);
            }
            cursor.close();//关闭结果集
        }
        //关闭数据库对象
        db.close();
    }


}

