package com.bumaiyangcong.uibestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msglist = new ArrayList<>();
    private TextView inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();//初始化消息数据
        inputText = (TextView) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msglist);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msglist.add(msg);
                    adapter.notifyItemInserted(msglist.size() - 1);//当有消息时，刷新recyclerview中的显示
                    msgRecyclerView.scrollToPosition(msglist.size() - 1);//将recyclerview定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("你好", Msg.TYPE_RECEIVED);
        msglist.add(msg1);
        Msg msg2 = new Msg("你好，你是谁？", Msg.TYPE_SEND);
        msglist.add(msg2);
        Msg msg3 = new Msg("我是to吗，很高兴认识你", Msg.TYPE_RECEIVED);
        msglist.add(msg3);
    }
}
