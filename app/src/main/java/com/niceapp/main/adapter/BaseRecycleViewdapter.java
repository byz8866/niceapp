package com.niceapp.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.niceapp.R;

import java.text.DecimalFormat;
import java.util.List;

public class BaseRecycleViewdapter extends RecyclerView.Adapter<BaseRecycleViewdapter.ViewHolder> {

    private List<String> recodeEntities;
    private LayoutInflater layoutInflater;
    Context context;
    DecimalFormat df = new DecimalFormat("0.000");

    public BaseRecycleViewdapter(Context context, List<String> list) {
        this.context = context;
        this.recodeEntities = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.base_item_recycleview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (recodeEntities == null) {
            return 0;
        }
        return recodeEntities.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNumber;

        public ViewHolder(View itemView) {
            super(itemView);


        }
    }
}
