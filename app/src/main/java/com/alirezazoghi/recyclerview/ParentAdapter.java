package com.alirezazoghi.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.itemHolder> {
    private Context context;
    private List<List<String>> lists;

    public ParentAdapter(Context context, List<List<String>> lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new itemHolder(LayoutInflater.from(context).inflate(R.layout.child_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        holder.recyclerView.setAdapter(new ChildAdapter(context, lists.get(position)));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }


    public class itemHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public itemHolder(@NonNull View v) {
            super(v);
            recyclerView = v.findViewById(R.id.child_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        }
    }
}
