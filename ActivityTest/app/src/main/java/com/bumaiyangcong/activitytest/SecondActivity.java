package com.bumaiyangcong.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //向下一个活动传递数据
//        Intent intent=getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.d("SecondActivity", data);

        //返回数据给上一个活动
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent();
                Intent intent1 = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
//                    intent.putExtra("date_return","Hello FirstActivity");
//                    setResult(RESULT_OK,intent);
//                    finish();
            }

        });
    }
}
