package com.example.crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KhataAdapter extends RecyclerView.Adapter<KhataAdapter.ViewHolder> {

    private List<KhataItem> khataList;

    public KhataAdapter(List<KhataItem> khataList) {
        this.khataList = khataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KhataItem khataItem = khataList.get(position);

        holder.textViewTitle.setText(khataItem.getTitle());
        holder.textViewDesc.setText(khataItem.getDescription());
        holder.textViewDate.setText(khataItem.getDate());
        holder.textViewPrice.setText(khataItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return khataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDesc, textViewDate, textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
