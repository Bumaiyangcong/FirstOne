package com.bumaiyangcong.SmsDao;

import com.bumaiyangcong.SmsBean.Smsbean;

import java.util.ArrayList;

/**
 * Created by pange on 公元17-06-29.
 */

public class SmsDao {
    //获取短信数据
    public static ArrayList<Smsbean> getAllSms() {

        ArrayList<Smsbean> arrayList = new ArrayList<Smsbean>();
        Smsbean smsbean=new Smsbean();
        smsbean.id=1;
        smsbean.number="110";
        smsbean.msg="来警局做个笔录";
        smsbean.date="2015-08-29";
        arrayList.add(smsbean);

        Smsbean smsbean2=new Smsbean();
        smsbean2.id=1;
        smsbean2.number="110";
        smsbean2.msg="来警局做个笔录";
        smsbean2.date="2015-08-29";
        arrayList.add(smsbean2);

        Smsbean smsbean3=new Smsbean();
        smsbean3.id=1;
        smsbean3.number="110";
        smsbean3.msg="来警局做个笔录";
        smsbean3.date="2015-08-29";
        arrayList.add(smsbean3);


        return arrayList;
    }
}
