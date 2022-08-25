package com.example.ultimatelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class EntryViewHolder extends RecyclerView.ViewHolder {
    private final TextView entryItemView;

    private EntryViewHolder(View itemView) {
        super(itemView);
        entryItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        entryItemView.setText(text);
    }

    static EntryViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new EntryViewHolder(view);
    }
}
