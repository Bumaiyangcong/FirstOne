package com.bumaiyangcong.demo1_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        //创建一个帮助类对象
        MySqliteOpenhelper mySqliteOpenhelper = new MySqliteOpenhelper(mContext);
        //调用getReadableDatabase方法，来初始化数据库的创建
        SQLiteDatabase db = mySqliteOpenhelper.getReadableDatabase();
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.query).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        InfoDao infoDao = new InfoDao(mContext);//创建一个dao对象做增删改查
        switch (v.getId()) {
            case R.id.add:
                InfoBean bean = new InfoBean();
                bean.name = "张三";
                bean.phone = "110";
                infoDao.add(bean);

                InfoBean bean1 = new InfoBean();
                bean1.name = "李四";
                bean.phone = "120";
                infoDao.add(bean1);
                break;
            case R.id.delete:
                infoDao.delete("张三");
                break;
            case R.id.update:
                InfoBean bean2 = new InfoBean();
                bean2.name = "张三";
                bean2.phone = "119";
                infoDao.add(bean2);
                break;
            case R.id.query:
                infoDao.query("张三");
                infoDao.query("李四");
                break;
        }
    }
}
