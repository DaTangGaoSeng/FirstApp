package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Recycleview extends AppCompatActivity {
        private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        initFruit();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Fruit_adapter adapter = new Fruit_adapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruit(){
        for(int i = 0;i < 1;i++){
            Fruit apple = new Fruit("apple",R.mipmap.apple);
            fruitList.add(apple);
            Fruit orange = new Fruit("orange",R.mipmap.orange);
            fruitList.add(orange);
            Fruit banana = new Fruit("banana",R.mipmap.banana);
            fruitList.add(banana);
            Fruit grape = new Fruit("grape",R.mipmap.grape);
            fruitList.add(grape);
            Fruit watermelon = new Fruit("watermelon",R.mipmap.watermelon);
            fruitList.add(watermelon);
            Fruit mango = new Fruit("mango",R.mipmap.mango);
            fruitList.add(mango);
            Fruit cherry = new Fruit("cherry",R.mipmap.cherry);
            fruitList.add(cherry);
        }
    }
}
