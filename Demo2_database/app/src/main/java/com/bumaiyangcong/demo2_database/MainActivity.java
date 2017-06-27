package com.bumaiyangcong.demo2_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(mContext);
        SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();

        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.query).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        InfoDao infoDao = new InfoDao(mContext);
        switch (v.getId()) {
            case R.id.add:
                Infobean bean = new Infobean();
                bean.name = "张三";
                bean.phone = "110";
                infoDao.add(bean);

                Infobean bean1 = new Infobean();
                bean1.name = "李四";
                bean1.phone = "120";
                infoDao.add(bean1);
                break;

            case R.id.delete:
                infoDao.delete("张三");
                break;

            case R.id.update:
                Infobean bean2 = new Infobean();
                bean2.name = "张三";
                bean2.phone = "119";
                infoDao.update(bean2);
                break;

            case R.id.query:
                infoDao.query("张三");
                infoDao.query("李四");
                break;
            default:
                break;
        }
    }
}
