package com.emef4z.moviebookmark;

import android.provider.BaseColumns;

public class MovieBookmarkDatabaseContract {

    private MovieBookmarkDatabaseContract(){}

    public static final class MovieInfoEntry implements BaseColumns {

        public static final String TABLE_NAME = "movie_info";
        public static final String COLUMN_MOVIE_NAME = "movie_name";
        public static final String COLUMN_MOVIE_TYPE = "movie_type";
        public static final String COLUMN_MOVIE_SEASON = "movie_season";
        public static final String COLUMN_MOVIE_EPISODE = "movie_episode";
        public static final String COLUMN_MOVIE_EPISODE_NAME = "movie_episode_name";
        public static final String COLUMN_MOVIE_TIMESTAMP = "movie_timestamp";
        public static final String COLUMN_MOVIE_RATING = "movie_rating";

        //CREATE INDEX movie_info_index ON movie_info(movie_name)
        public static final String INDEX1 = TABLE_NAME+"_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME + "(" + COLUMN_MOVIE_NAME + ")";


        /*  CREATE TABLE movie_info (_id INTEGER PRIMARY KEY,movie_name TEXT NOT NULL,movie_type TEXT NOT NULL,
            movie_season TEXT NOT NULL,movie_episode  TEXT NOT NULL,movie_episode_name TEXT,
            movie_timestamp TEXT NOT NULL,movie_rating TEXT NOT NULL)
        */

        public static final String SQL_CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+
                _ID+" INTEGER PRIMARY KEY, " +
                COLUMN_MOVIE_NAME+" TEXT NOT NULL, "+
                COLUMN_MOVIE_TYPE+" TEXT NOT NULL, "+
                COLUMN_MOVIE_EPISODE +" TEXT, "+
                COLUMN_MOVIE_SEASON +" TEXT, "+
                COLUMN_MOVIE_EPISODE_NAME +" TEXT, "+
                COLUMN_MOVIE_TIMESTAMP + " TEXT NOT NULL, "+
                COLUMN_MOVIE_RATING +" TEXT NOT NULL)";
    }
}
