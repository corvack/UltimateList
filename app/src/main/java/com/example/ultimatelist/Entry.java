package com.example.ultimatelist;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "entry_table")
public class Entry {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "entry")
    private String mEntry;

    public Entry(@NonNull String entry) {this.mEntry = entry;}

    public String getEntry(){return this.mEntry;}
}
