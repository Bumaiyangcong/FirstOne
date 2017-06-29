package com.bumaiyangcong.SmsDao;

import com.bumaiyangcong.SmsBean.SmsBean;

import java.util.ArrayList;

/**
 * Created by pange on 公元17-06-29.
 */

public class SmsDao {
    public static ArrayList<SmsBean>  getAllSms() {
        ArrayList<SmsBean> arrayList = new ArrayList<>();

        SmsBean smsBean1=new SmsBean();
        smsBean1.id=1;
        smsBean1.number="110";
        smsBean1.msg="来警局做个笔录";
        smsBean1.date="2015-0-09";
        arrayList.add(smsBean1);


        SmsBean smsBean2=new SmsBean();
        smsBean2.id=2;
        smsBean2.number="120";
        smsBean2.msg="最近身体好吗";
        smsBean2.date="2015-0-09";
        arrayList.add(smsBean2);

        SmsBean smsBean3=new SmsBean();
        smsBean3.id=3;
        smsBean3.number="119";
        smsBean3.msg="火灭了吗";
        smsBean3.date="2015-0-09";
        arrayList.add(smsBean3);


        return arrayList;
    }
}
