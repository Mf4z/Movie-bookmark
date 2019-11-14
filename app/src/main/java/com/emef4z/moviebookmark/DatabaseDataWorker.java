package com.emef4z.moviebookmark;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.emef4z.moviebookmark.MovieBookmarkDatabaseContract.MovieInfoEntry;

public class DatabaseDataWorker {

    private SQLiteDatabase mDb;

    public DatabaseDataWorker() {
    }

    public DatabaseDataWorker(SQLiteDatabase db){

        this();
        this.mDb = db;
    }

    public void insertSampleMovies(){

        insertMovies("Joker","Movie","15:12","5");
        insertMovies("Mr Robot","Series","1","2","1_ones-and-zer0es","15:12","5");
    }



    private void insertMovies(String name,String type,String timestamp,String rating) {
        ContentValues values = new ContentValues();
        values.put(MovieInfoEntry.COLUMN_MOVIE_NAME,name);
        values.put(MovieInfoEntry.COLUMN_MOVIE_TYPE,type);
        values.put(MovieInfoEntry.COLUMN_MOVIE_TIMESTAMP,timestamp);
        values.put(MovieInfoEntry.COLUMN_MOVIE_NAME,rating);

        long newRowId = mDb.insert(MovieInfoEntry.TABLE_NAME, null, values);
    }

    private void insertMovies(String name,String type,String season,String episode,String epName,String timestamp,String rating) {
        ContentValues values = new ContentValues();
        values.put(MovieInfoEntry.COLUMN_MOVIE_NAME,name);
        values.put(MovieInfoEntry.COLUMN_MOVIE_TYPE,type);
        values.put(MovieInfoEntry.COLUMN_MOVIE_SEASON,season);
        values.put(MovieInfoEntry.COLUMN_MOVIE_EPISODE,episode);
        values.put(MovieInfoEntry.COLUMN_MOVIE_EPISODE_NAME,epName);
        values.put(MovieInfoEntry.COLUMN_MOVIE_TIMESTAMP,timestamp);
        values.put(MovieInfoEntry.COLUMN_MOVIE_NAME,rating);

        long newRowId = mDb.insert(MovieInfoEntry.TABLE_NAME, null, values);
    }


}
