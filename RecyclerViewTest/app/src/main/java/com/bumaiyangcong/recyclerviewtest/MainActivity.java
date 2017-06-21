package com.bumaiyangcong.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        LayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(LayoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitlist);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitlist.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitlist.add(banana);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitlist.add(cherry);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitlist.add(grape);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitlist.add(mango);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitlist.add(orange);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitlist.add(pear);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitlist.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitlist.add(strawberry);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitlist.add(watermelon);
        }


    }
}
