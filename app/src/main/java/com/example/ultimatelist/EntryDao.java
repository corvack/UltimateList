package com.example.ultimatelist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EntryDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Entry entry);

    @Query("DELETE FROM entry_table")
    void deleteAll();

    @Query("SELECT * FROM entry_table ORDER BY entry ASC")
    LiveData<List<Entry>> getAlphabetizedEntries();
}
