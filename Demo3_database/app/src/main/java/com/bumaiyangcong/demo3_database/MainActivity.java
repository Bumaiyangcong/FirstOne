package com.bumaiyangcong.demo3_database;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext = this;
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.query).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        InfoDao infoDao = new InfoDao(mcontext);//创建一个dao对象做增删改查
        switch (v.getId()) {
            case R.id.add:
                InfoBean bean = new InfoBean();
                bean.name = "张三";
                bean.phone = "110";
                boolean result = infoDao.add(bean);
                if (result) {
                    Toast.makeText(mcontext, "添加成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mcontext, "添加失败", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.delete:
                int delete = infoDao.del("张三");
                Toast.makeText(mcontext, "成功删除" + delete + "行", Toast.LENGTH_SHORT).show();
                break;

            case R.id.update:
                InfoBean bean2 = new InfoBean();
                bean2.name = "张三";
                bean2.phone = "119";
                int update = infoDao.update(bean2);
                Toast.makeText(mcontext, "成功修改" + update + "行", Toast.LENGTH_SHORT).show();
                break;

            case R.id.query:
                infoDao.query("张三");
                break;

            default:
                break;


        }
    }
}
