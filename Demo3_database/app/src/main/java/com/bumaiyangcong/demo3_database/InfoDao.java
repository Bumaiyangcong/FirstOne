package com.bumaiyangcong.demo3_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pange on 公元17-06-27.
 */

public class InfoDao {
    private MySqliteOpenhelper mySqliteOpenhelper;

    public InfoDao(Context context) {
        mySqliteOpenhelper = new MySqliteOpenhelper(context);

    }

    public boolean add(InfoBean bean) {
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        ContentValues values = new ContentValues();//用map封装的对象，用来存放值
        values.put("name", bean.name);
        values.put("phone", bean.phone);
        //table: 表名 , nullColumnHack：可以为空，标示添加一个空行,
        // values:数据一行的值,
        // 返回值：代表添加这个新行的Id ，-1代表添加失败

        long result = db.insert("info", null, values);//底层是在拼装SQL语句
        //关闭数据库对象
        db.close();
        if (result != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int del(String name) {
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        //table ：表名, whereClause: 删除条件, whereArgs：条件的占位符的参数 ;
        // 返回值：成功删除多少行
        int result = db.delete("info", "name=?", new String[]{name});
        db.close();
        return result;
    }

    public int update(InfoBean bean) {
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone ", bean.phone);
        //table:表名, values：更新的值, whereClause:更新的条件, whereArgs：更新条件的占位符的值,
        // 返回值：成功修改多少行
        int result = db.update("info", values, "name=?", new String[]{bean.name});
        db.close();
        return result;
    }

    public void query(String name) {
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        //table:表名, columns：查询的列名,如果null代表查询所有列； selection:查询条件,
        // selectionArgs：条件占位符的参数值,
        //groupBy:按什么字段分组, having:分组的条件, orderBy:按什么字段排序
        Cursor cursor = db.query("info", new String[]{"_id", "name", "phone"}, "name=?", new String[]{name}, null, null, "_id desc");
        //解析cursor中的数据
        if (cursor != null && cursor.getCount() > 0) {//判断cursor中是否存在数据

            //循环遍历结果集，获取每一行内容
            while (cursor.moveToNext()) {//条件，游标能否定位到下一行
                //获取数据
                int id = cursor.getInt(0);
                String name_str = cursor.getString(1);
                String phone = cursor.getString(2);
                System.out.println("_id:" + id + ";name:" + name_str + ";phone:" + phone);


            }
            cursor.close();
        }
        db.close();
    }
}


