package com.example.ultimatelist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EntryViewModel extends AndroidViewModel {

    private EntryRepository mRepository;

    private final LiveData<List<Entry>> mAllEntries;

    public EntryViewModel (Application application) {
        super(application);
        mRepository = new EntryRepository(application);
        mAllEntries = mRepository.getAllEntries();
    }

    LiveData<List<Entry>> getAllEntries() { return mAllEntries; }

    public void insert(Entry entry) { mRepository.insert(entry); }
}
