package com.bumaiyangcong.demo1_createdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        //创建一个帮助类对象
        MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(mContext);
        SQLiteDatabase db=mySqliteOpenHelper.getReadableDatabase();

    }
}
