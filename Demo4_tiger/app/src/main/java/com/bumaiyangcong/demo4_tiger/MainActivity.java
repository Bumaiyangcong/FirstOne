package com.bumaiyangcong.demo4_tiger;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext=this;
        //找到控件
        ListView tiger1 = (ListView) findViewById(R.id.tiger1);
        ListView tiger2 = (ListView) findViewById(R.id.tiger2);
        ListView tiger3 = (ListView) findViewById(R.id.tiger3);
        //创建adapter设置给listview
        TigerAdapter tigerAdapter=new TigerAdapter();
        tiger1.setAdapter(tigerAdapter);
        tiger2.setAdapter(tigerAdapter);
        tiger3.setAdapter(tigerAdapter);

    }
    class TigerAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 500;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view=null;
            //复用convertView
            if (convertView!=null){
                view=(TextView)convertView;
            }else{
                view=new TextView(mcontext);
            }
            Random random=new Random();
            int number = random.nextInt(100);
            if (number<20){
                view.setTextColor(Color.parseColor("#ff00ff"));//设置textview文字颜色
                view.setText("桃");
            }else if (number<40){
                view.setTextColor(Color.YELLOW);
                view.setText("杏");
            }else if (number<60){
                view.setTextColor(Color.GREEN);
                view.setText("梨");
            }else if (number<80){
                view.setTextColor(Color.RED);
                view.setText("枣");
            }else{
                view.setTextColor(Color.parseColor("#666666"));
                view.setText("瓜");
            }
            view.setTextSize(58);

            return view;
        }
    }

}