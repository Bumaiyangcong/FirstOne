package com.bumaiyangcong.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("this is content title")
                        .setContentText("一生には一回しかない、一回でも一生のことだ")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        //第一种状态栏上图标消失的方法
                        // .setAutoCancel(true)
                        //设置有通知时手机震动
                        .setVibrate(new long[]{0, 1000, 1000, 1000})
                        //设置设置前置led灯
                        .setLights(Color.GREEN, 1000, 1000)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("一生には一回しかない、一回でも一生のことだhhhhhhhhhhhhhhhhh"))
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)))
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }

}

