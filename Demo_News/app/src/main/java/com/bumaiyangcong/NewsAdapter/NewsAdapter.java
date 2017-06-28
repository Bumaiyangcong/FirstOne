package com.bumaiyangcong.NewsAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumaiyangcong.NewsBean.NewsBean;
import com.bumaiyangcong.demo_news.R;

import java.util.ArrayList;

/**
 * Created by pange on 公元17-06-28.
 */

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NewsBean> list;

    public NewsAdapter(Context context, ArrayList<NewsBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        //1,复用converView优化listview,创建一个view作为getview的返回值用来显示一个条目
        if (convertView != null) {
            view = convertView;
        } else {
            //context:上下文, resource:要转换成view对象的layout的id,
            // root:将layout用root(ViewGroup)包一层作为codify的返回值,一般传null
            view = View.inflate(context, R.layout.item_news_layout, null);//将一个布局文件转换成一个view对象
        }
        //2，获取view上的子控件
        ImageView image_icon = (ImageView) view.findViewById(R.id.image_icon);
        TextView des = (TextView) view.findViewById(R.id.des);
        TextView title = (TextView) view.findViewById(R.id.title);
        //3，获取条目对应的list集合中的新闻数据bean对象
        NewsBean newsBean = list.get(position);
        //4，将数据设置给这些子控件做显示
        image_icon.setImageDrawable(newsBean.icon);//设置imageview的图片
        des.setText(newsBean.des);
        title.setText(newsBean.title);

        return view;
    }
}
