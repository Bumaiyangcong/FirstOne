package com.bumaiyangcong.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pange on 公元17-06-09.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;


    public FruitAdapter( Context context,  int textViewResourceId,  List<Fruit> objects) {
        super(context, textViewResourceId,  objects);
         resourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit=getItem(position);
        View view;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view=convertView;
        }
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;

    }

}
