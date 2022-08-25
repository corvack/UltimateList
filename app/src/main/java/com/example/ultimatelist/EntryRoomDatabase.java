package com.example.ultimatelist;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Entry.class}, version = 1, exportSchema = false)
public abstract class EntryRoomDatabase extends RoomDatabase {
    public abstract EntryDao entryDao();

    private static volatile EntryRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static EntryRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EntryRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    EntryRoomDatabase.class, "entry_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                EntryDao dao = INSTANCE.entryDao();
                dao.deleteAll();

                Entry entry = new Entry("Hello");
                dao.insert(entry);
                entry = new Entry("World");
                dao.insert(entry);
                entry = new Entry("Nintendo Entertainment System");
                dao.insert(entry);
                entry = new Entry("Super Mario Bros.");
                dao.insert(entry);
                entry = new Entry("Super Nintendo Entertainment System");
                dao.insert(entry);
                entry = new Entry("Nintendo 64");
                dao.insert(entry);

            });
        }
    };
}
