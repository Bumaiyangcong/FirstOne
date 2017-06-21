package com.bumaiyangcong.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pange on 公元17-06-09.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {  //定义一个内部类继承RecyclerView.ViewHolder
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {    //ViewHolder 的构造函数中传入view参数
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);//通过findViewById方法获取布局中imageview 和textview实例
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {    //构造函数把把要用于展示的数据源传进来并赋值给一个全局变量mFruitList

        mFruitList = fruitList;
    }

    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
