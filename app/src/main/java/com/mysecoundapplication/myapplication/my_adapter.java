package com.mysecoundapplication.myapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class my_adapter extends RecyclerView.Adapter<my_adapter.ViewHolder> {
    private final List<String> values;

    public my_adapter(List<String> my_dataset){
        values = my_dataset;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v  = inflater.inflate(R.layout.view_item,parent,false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name = values.get(position);
        holder.textView2.setText(name);
        holder.textView2.setOnClickListener(view -> remove(position));
        holder.textView1.setText("Footer"+name);

    }
    public void remove(int position){
        values.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView1,textView2;
        public View layout;

        public ViewHolder(View itemView) {
            super(itemView);

            textView2 = (TextView) itemView.findViewById(R.id.text_view2);
            textView1 = (TextView) itemView.findViewById(R.id.text_view1);
        }
    }
}
