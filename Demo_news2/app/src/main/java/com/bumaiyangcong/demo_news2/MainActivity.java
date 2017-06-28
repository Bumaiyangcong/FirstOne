package com.bumaiyangcong.demo_news2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bumaiyangcong.NewsAdapter.NewsAdapter;
import com.bumaiyangcong.NewsBean.NewsBean;
import com.bumaiyangcong.NewsUtils.NewsUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        //1.找到控件
        ListView lv_news = (ListView) findViewById(R.id.lv_news);

        //2.获取新闻数据用list封装
        ArrayList<NewsBean> allNews = NewsUtils.getAllNews(mContext);

        //3.创建一个adapter设置给listview
        NewsAdapter newsadapter=new NewsAdapter(mContext,allNews);
        lv_news.setAdapter(newsadapter);

        //4.设置listview条目的点击事件
        lv_news.setOnItemClickListener(this);
    }
    //listview的条目点击时会调用该方法 parent:代表listviw  view:点击的条目上的那个view对象
    // position:条目的位置  id： 条目的id
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //需要获取条目上bean对象中url做跳转
        NewsBean bean=(NewsBean) parent.getItemAtPosition(position);
        String url=bean.news_url;

        //跳转浏览器
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
