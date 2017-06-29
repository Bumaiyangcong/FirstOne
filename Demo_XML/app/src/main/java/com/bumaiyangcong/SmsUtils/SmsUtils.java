package com.bumaiyangcong.SmsUtils;

import android.content.Context;

import com.bumaiyangcong.SmsBean.SmsBean;
import com.bumaiyangcong.SmsDao.SmsDao;

import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by pange on 公元17-06-29.
 */

public class SmsUtils {

    public static boolean backupSms(Context context) {
        //获取短信内容list
        ArrayList<SmsBean> allSms = SmsDao.getAllSms();
        //将数据以xml格式封装到StringBuffer中
        StringBuffer sb=new StringBuffer();
        //封装一个声明头
        sb.append("<?xml version='1.0' encoding='utf-8' standalone='yes'?>");
        //封装根结点
        sb.append("<Smss>");
        //循环遍历list集合封装所有的短信
        for(SmsBean smsBean:allSms){
            sb.append("<Sms id = \""+smsBean.id+"\">");
            sb.append("<num>");
            sb.append(smsBean.number);
            sb.append("</num>");

            sb.append("<msg>");
            sb.append(smsBean.msg);
            sb.append("</msg>");


            sb.append("<date>");
            sb.append(smsBean.date);
            sb.append("</date>");

            sb.append("</Sms>");
        }
        sb.append("</Smss>");


        //将stringBuffer中的xml字符串写入私有目录中的文件
        try {
            FileOutputStream openFileOutput = context.openFileOutput("backupsms.xml", Context.MODE_PRIVATE);
            openFileOutput.write(sb.toString().getBytes());
            openFileOutput.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void restoreSms() {

    }
}
