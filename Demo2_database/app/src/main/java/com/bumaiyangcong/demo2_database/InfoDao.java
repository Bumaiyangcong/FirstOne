package com.bumaiyangcong.demo2_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pange on 公元17-06-27.
 */

public class InfoDao {

    private MySqliteOpenHelper mMySqliteOpenHelper;

    public InfoDao(Context context) {
        //创建一个帮助类对象
        mMySqliteOpenHelper = new MySqliteOpenHelper(context);
    }

    public  void add(Infobean bean) {
        SQLiteDatabase db = mMySqliteOpenHelper.getWritableDatabase();
        db.execSQL("insert into info(name,phone) values(?,?);", new Object[]{bean.name, bean.phone});
        //关闭数据库
        db.close();
    }

    public void delete(String name) {
        SQLiteDatabase db = mMySqliteOpenHelper.getWritableDatabase();
        db.execSQL("delete from info where name=?;", new Object[]{name});
        db.close();

    }

    public void update(Infobean bean) {
        SQLiteDatabase db = mMySqliteOpenHelper.getWritableDatabase();
        db.execSQL("update info set phone=? where name=?;", new Object[]{bean.phone, bean.name});
        db.close();
    }

    public void query(String name) {
        SQLiteDatabase db = mMySqliteOpenHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select _id,name,phone from info where name", new String[]{name});
        if (cursor != null && cursor.getCount() > 0) {//判断cursor中是否存在数据
            while (cursor.moveToNext()) {//条件，游标能否定位到下一行
                //获取数据
                int id = cursor.getInt(0);
                String name_str = cursor.getString(1);
                String phone = cursor.getString(2);
                System.out.println("_id:"+id+";name:"+name_str+";phone:"+phone);
            }
            cursor.close();//关闭结果集
        }
        db.close();
    }
}
