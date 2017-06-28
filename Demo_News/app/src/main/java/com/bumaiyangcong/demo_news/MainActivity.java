package com.bumaiyangcong.demo_news;

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
/*1.布局写listview ok

	2.找到listview ok

	3.封装新闻数据到list集合中 ，目的是为adapter提供数据展示。 ok

	4.封装一个Adapter类继承BaseAdatper，写一个构造方法接受list集合数据，复写四个方法
		a.创建一个构造方法  ok
		b.封装getCount方法   ok
		c.getView方法：   不ok
			1.复用convertview，模板代码,如果不都能空，需要将一个布局文件转换为view对象作为getview的返回对象。
				view = View.inflater(Context context, int resuorceId,ViewGroup root)
			2.找到view上的这些子控件，目的是将list集合中的bean数据一一对应设置给这些子控件

			3.从list集合中获取postion条目上要显示的数据Bean

			4.将获取的bean中的数据设置给这些子控件
		d.getItem方法：将list集合中指定postion上的bean对象返回
		e.getItemId,直接返回postion

	5.创建一个封装的Adapter对象，设置给listview   ok
	6.设置listview条目的点击事件  ok
		listview.setOnItem....

	7.复写OnItemClicklistener方法，获取相应条目上的bean对象，最终获取到url，做Intent跳转;  不ok

**/

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        //找到控件
        ListView news = (ListView) findViewById(R.id.news);
        //获取新闻数据用list封装
        ArrayList<NewsBean> allNews = NewsUtils.getAllNews(mContext);
        //创建一个adapter设置给listview
        NewsAdapter newsAdapter = new NewsAdapter(mContext, allNews);
        news.setAdapter(newsAdapter);

        news.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsBean bean = (NewsBean) parent.getItemAtPosition(position);
        String url = bean.url;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

   /* // listview的条目点击时毁掉哟过该方法
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object object = parent.getItemAtPosition(position);
        if (object == null) {
            Toast.makeText(mContext, "id:" + "", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "position:" + position + "", Toast.LENGTH_SHORT).show();
        }
    }*/
}
