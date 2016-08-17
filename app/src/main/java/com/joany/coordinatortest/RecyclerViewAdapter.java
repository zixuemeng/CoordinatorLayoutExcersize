package com.joany.coordinatortest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jiqiong.jq on 2016/8/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder> {
    private Context context;
    private List<String> list;

    public RecyclerViewAdapter(Context context,List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListViewHolder holder = new ListViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ListViewHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
