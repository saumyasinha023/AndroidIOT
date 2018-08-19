package com.example.saumya.ovendemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    List<String>mDataset;
    Context mContext;
    public RecycleAdapter(Context mContext, List<String> animalsList) {
        this.mContext=mContext;
        this.mDataset=animalsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.custom_view,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText((String)mDataset.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String animal=mDataset.get(position);
                Toast.makeText(mContext,animal,Toast.LENGTH_LONG).show();
            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemLabel=mDataset.get(position);
                mDataset.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,mDataset.size());
                Toast.makeText(mContext,"Removed"+""+itemLabel,Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageButton img;
        RelativeLayout rLayout;
        public ViewHolder(View itemView) {
            super(itemView);
                textView=(TextView)itemView.findViewById(R.id.textView);
                img=(ImageButton)itemView.findViewById(R.id.imgButton);
                rLayout=(RelativeLayout)itemView.findViewById(R.id.rLayout);
        }
    }
}
