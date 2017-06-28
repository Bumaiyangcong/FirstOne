package com.bumaiyangcong.NewsUtils;

import android.content.Context;

import com.bumaiyangcong.NewsBean.NewsBean;
import com.bumaiyangcong.demo_news2.R;

import java.util.ArrayList;

/**
 * Created by pange on 公元17-06-28.
 */

public class NewsUtils {
    //封装新闻数据到list集合
    public static ArrayList<NewsBean> getAllNews(Context context) {
        ArrayList<NewsBean>arrayList=new ArrayList<NewsBean>();

        for (int i=0;i<100;i++) {
            NewsBean newsBean = new NewsBean();
            newsBean.title = "谢霆锋经纪人：偷拍系侵权行为：";
            newsBean.des = "称谢霆锋隐私权收到侵犯，将保留追究法律责任";
            newsBean.news_url = "www.sina.cn";
            newsBean.icon = context.getResources().getDrawable(R.mipmap.ic_launcher);
            arrayList.add(newsBean);

            NewsBean newsBean1 = new NewsBean();
            newsBean1.title = "谢霆锋经纪人：偷拍系侵权行为：";
            newsBean1.des = "称谢霆锋隐私权收到侵犯，将保留追究法律责任";
            newsBean1.news_url = "www.baidu.com";
            newsBean1.icon = context.getResources().getDrawable(R.drawable.icon2);
            arrayList.add(newsBean1);

            NewsBean newsBean2 = new NewsBean();
            newsBean2.title = "谢霆锋经纪人：偷拍系侵权行为：";
            newsBean2.des = "称谢霆锋隐私权收到侵犯，将保留追究法律责任";
            newsBean2.news_url = "www.itheima.com";
            newsBean2.icon = context.getResources().getDrawable(R.drawable.icon);
            arrayList.add(newsBean2);

        }
        return arrayList;

    }
}
