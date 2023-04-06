package com.example.roadsafetyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    // 4. Handling the Click Events
    private ItemClickListener clickListener;
    // 1. Data Source
    private RoadModel[] listData;

    public MyAdapter(RoadModel[] listData){
        this.listData = listData;
    }


    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // 2. View Holder Class
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(clickListener != null){
                clickListener.onClick(view, getAdapterPosition());
            }
        }
    }

    // 3. Implementing the methods

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recyclerview_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final RoadModel myListData = listData[position];
        holder.imageView.setImageResource(listData[position].getImage());
        holder.textView.setText(listData[position].getTitle());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

}
