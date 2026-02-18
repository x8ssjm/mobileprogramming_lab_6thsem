package com.app.labbca6thsem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    String[] items;
    int[] icons;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String itemName);
    }

    public RecyclerAdapter(String[] items, int[] icons, OnItemClickListener listener) {
        this.items = items;
        this.icons = icons;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(items[position]);
        holder.icon.setImageResource(icons[position]);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(items[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.recycler_icon);
            name = itemView.findViewById(R.id.recycler_name);
        }
    }
}
