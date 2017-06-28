package com.bumaiyangcong.NewsAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumaiyangcong.NewsBean.NewsBean;
import com.bumaiyangcong.demo_news2.R;

import java.util.ArrayList;

/**
 * Created by pange on 公元17-06-28.
 */

public class NewsAdapter extends BaseAdapter {
    private ArrayList<NewsBean> list;
    private Context context;


    public NewsAdapter(Context context, ArrayList<NewsBean> List) {
        this.context = context;
        this.list = list;
    }

    //How many items are in the data set represented by this Adapter.返回：Count of items.
    //要展示的数据有多少条，即集合的size；
    @Override
    public int getCount() {
        return list.size();
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
    View view=null;
        //1.复用converView优化listview,创建一个view作为getview的返回值用来显示一个条目
      if (convertView!=null){
          view=convertView;
      } else{
          //context:上下文, resource:要转换成view对象的layout的id,
          // root:将layout用root(ViewGroup)包一层作为codify的返回值,一般传null
          view=view.inflate(context, R.layout.news_layout,null);//将一个布局文件转换成一个view对象
      }
      //2.获取view上的子控件对象
        ImageView image_icon = (ImageView) view.findViewById(R.id.image_icon);
        TextView tv_des = (TextView) view.findViewById(R.id.tv_des);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);

        //3.获取postion位置条目对应的list集合中的新闻数据，Bean对象
        NewsBean newsBean = list.get(position);
        //4.将数据设置给这些子控件做显示
        image_icon.setImageDrawable(newsBean.icon);
        tv_title.setText(newsBean.title);
        tv_des.setText(newsBean.des);
        return view;
    }
}
