package com.yang.materialdesigndemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 洋 on 2016/7/8.
 */
public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
    private OnRecyclerItemClickListener listener;
    public ImageView bookIv;
    public TextView titleTv;
    public TextView descTv;
    public BookViewHolder(View itemView,OnRecyclerItemClickListener listener) {
        super(itemView);
        bookIv = (ImageView) itemView.findViewById(R.id.iv_book);
        titleTv = (TextView) itemView.findViewById(R.id.text_title);
        descTv = (TextView) itemView.findViewById(R.id.text_description);
        this.listener = listener;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

    @Override
    public boolean onLongClick(View v) {
        if(listener!=null) {
            listener.OnItemLongClick(getAdapterPosition());
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null) {
            listener.OnItemClick(getAdapterPosition());
        }
    }
}
