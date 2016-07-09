package com.yang.materialdesigndemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 洋 on 2016/7/9.
 */
public class ControlRecyclerAdapter extends RecyclerView.Adapter<ControlRecyclerAdapter.ControlViewHolder> {


    private String[] names;
    private OnRecyclerItemClickListener listener;

    public ControlRecyclerAdapter(OnRecyclerItemClickListener listener){
        this.listener = listener;
    }

    public void setNames(String[] names) {
        this.names = names;
        notifyDataSetChanged();
    }

    @Override
    public ControlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_control,
                parent,false);

        return new ControlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ControlViewHolder holder, int position) {

        holder.nameTv.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return names==null?0:names.length;
    }

    public class ControlViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameTv;
        public ControlViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.text_control_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener!=null) {
                listener.OnItemClick(getAdapterPosition());
            }
        }
    }

}
