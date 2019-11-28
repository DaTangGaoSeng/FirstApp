package com.example.firstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Fruit_adapter extends RecyclerView.Adapter<Fruit_adapter.ViewHolder> {
    private List<Fruit> fruitList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImagine;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            fruitImagine = (ImageView)view.findViewById(R.id.fruit_imagine);
            fruitName = (TextView)view.findViewById(R.id.fruit_name);
        }
    }
    public Fruit_adapter(List<Fruit> fruitList){
        this.fruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fruit_item,parent,false);
                ViewHolder viewHolder = new ViewHolder(view);
                return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruitImagine.setImageResource(fruit.getImagineId());
        holder.fruitName.setText(fruit.getName());
    }

    public int getItemCount(){
        return fruitList.size();
    }
}
