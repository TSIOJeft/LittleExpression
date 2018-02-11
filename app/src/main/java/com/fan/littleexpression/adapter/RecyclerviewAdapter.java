package com.fan.littleexpression.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fan.littleexpression.R;

import java.util.ArrayList;

/**
 * Created by Fan on 2018/2/1.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.mViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private ArrayList<BitmapDrawable> data;
    private Context context;
    private OnRecyclerViewClickListener onRecyclerViewClickListener = null;

    public RecyclerviewAdapter(Context context, ArrayList<BitmapDrawable> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerviewAdapter.mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        view.setOnLongClickListener(this);
        view.setOnClickListener(this);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        if (data.isEmpty()) {
            return;
        }
        holder.Expression_image.setImageDrawable(data.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {
        if (onRecyclerViewClickListener != null) {
            onRecyclerViewClickListener.OnItemClick(view, (int) view.getTag());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (onRecyclerViewClickListener != null) {
            onRecyclerViewClickListener.OnItemLongClick(view, (int) view.getTag());
        }
        return true;
    }

    //点击事件
    public static interface OnRecyclerViewClickListener {
        void OnItemClick(View view, int p);

        void OnItemLongClick(View v, int p);
    }

    class mViewHolder extends RecyclerView.ViewHolder {
        ImageView Expression_image = (ImageView) itemView.findViewById(R.id.expression_image);

        mViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setOnRecyclerViewClickListener(OnRecyclerViewClickListener listener) {
        this.onRecyclerViewClickListener = listener;
    }
}