package com.example.ultimatelist;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class EntryListAdapter extends ListAdapter<Entry, EntryViewHolder> {

    public EntryListAdapter(@NonNull DiffUtil.ItemCallback<Entry> diffCallback) {
        super(diffCallback);
    }

    @Override
    public EntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return EntryViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(EntryViewHolder holder, int position) {
        Entry current = getItem(position);
        holder.bind(current.getEntry());
    }

    static class WordDiff extends DiffUtil.ItemCallback<Entry> {

        @Override
        public boolean areItemsTheSame(@NonNull Entry oldItem, @NonNull Entry newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Entry oldItem, @NonNull Entry newItem) {
            return oldItem.getEntry().equals(newItem.getEntry());
        }
    }
}
