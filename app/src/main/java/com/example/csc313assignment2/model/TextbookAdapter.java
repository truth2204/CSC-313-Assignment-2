package com.example.csc313assignment2.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csc313assignment2.R;
import java.util.List;

public class TextbookAdapter extends RecyclerView.Adapter<TextbookAdapter.TextbookViewHolder> {

    private List<Textbook> textbookList;

    public TextbookAdapter(List<Textbook> textbookList) {
        this.textbookList = textbookList;
    }

    @NonNull
    @Override
    public TextbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_textbook, parent, false);
        return new TextbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextbookViewHolder holder, int position) {
        Textbook textbook = textbookList.get(position);
        holder.titleTextView.setText(textbook.getTitle());
        holder.sellerTextView.setText(textbook.getSeller());
        holder.priceTextView.setText("R" + textbook.getPrice());
    }

    @Override
    public int getItemCount() {
        return textbookList.size();
    }

    public void updateList(List<Textbook> filteredList) {
        textbookList = filteredList;
        notifyDataSetChanged();
    }

    static class TextbookViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, sellerTextView, priceTextView;

        public TextbookViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textbookTitle);
            sellerTextView = itemView.findViewById(R.id.sellerName);
            priceTextView = itemView.findViewById(R.id.textbookPrice);
        }
    }
}



