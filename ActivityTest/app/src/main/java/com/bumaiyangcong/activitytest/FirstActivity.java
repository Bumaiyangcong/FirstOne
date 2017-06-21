package com.bumaiyangcong.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", this.toString());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // Toast.makeText(FirstActivity.this,"你点击了Button 1",Toast.LENGTH_SHORT).show();
                //finish();//销毁按钮，相当于Back按键
               /* 显示intent
               Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                */
               //隐示intent
                // Intent intent = new Intent("com.bumaiyangcong.activitytest.ACTION_START");
              //  intent.addCategory("com.bumaiyangcong.activitytest.MY_CATEGORY");
                //调用系统浏览器
                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);*/
                //调用系统拨号界面
               /* Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

               //向下一个活动传递数据
              /*  String date="Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);*/

              //返回数据给上一个活动
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }

        });
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "你点击了Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "你点击了Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }*/
}
