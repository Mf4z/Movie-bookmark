package com.emef4z.moviebookmark;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.emef4z.moviebookmark.MovieBookmarkDatabaseContract.MovieInfoEntry;

public class MovieBookmarkOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Moviebookmark.db";
    public static final int DATABASE_VERSION = 1;

    public MovieBookmarkOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MovieInfoEntry.SQL_CREATE_TABLE);
        db.execSQL(MovieInfoEntry.SQL_CREATE_INDEX1);

        DatabaseDataWorker worker = new DatabaseDataWorker(db);
        worker.insertSampleMovies();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
