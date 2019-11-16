package com.emef4z.moviebookmark;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emef4z.moviebookmark.MovieBookmarkDatabaseContract.MovieInfoEntry;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private Cursor mCursor;
    private LayoutInflater mInflater;
    private int mPosId;
    private int mMovieNamePos;
    private int mMovieTypePos;
    private int mSeasonPos;
    private int mEpisodePos;
    private int mEpisodeNamePos;
    private int mTimestampPos;
    private int mRatingPos;

    public MovieRecyclerAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
        mInflater = LayoutInflater.from(context);

        populateColumnPositions();

    }

    private void populateColumnPositions() {
        if (mCursor == null)
            return;

        mPosId = mCursor.getColumnIndex(MovieInfoEntry._ID);
        mMovieNamePos = mCursor.getColumnIndex(MovieInfoEntry.COLUMN_MOVIE_NAME);
        mMovieTypePos = mCursor.getColumnIndex(MovieInfoEntry.COLUMN_MOVIE_TYPE);
        mSeasonPos = mCursor.getColumnIndex(MovieInfoEntry.COLUMN_MOVIE_SEASON);
        mEpisodePos = mCursor.getColumnIndex(MovieInfoEntry.COLUMN_MOVIE_EPISODE);
        mEpisodeNamePos = mCursor.getColumnIndex(MovieInfoEntry.COLUMN_MOVIE_EPISODE_NAME);
        mTimestampPos = mCursor.getColumnIndex(MovieInfoEntry.COLUMN_MOVIE_TIMESTAMP);
        mRatingPos = mCursor.getColumnIndex(MovieInfoEntry.COLUMN_MOVIE_RATING);
    }

    public void changeCursor(Cursor cursor){
            if (cursor != null)
                cursor.close();

            mCursor = cursor;
            populateColumnPositions();
            notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.movie_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        int id = mCursor.getInt(mPosId);
        String movieName = mCursor.getString(mMovieNamePos);
        String movieType = mCursor.getString(mMovieTypePos);
        String movieSeason = mCursor.getString(mSeasonPos);
        String movieEpisode = mCursor.getString(mEpisodePos);
        String movieEpisodeName = mCursor.getString(mEpisodeNamePos);
        String movieTimestamp = mCursor.getString(mTimestampPos);
        String movieRating = mCursor.getString(mRatingPos);


        holder.mId = id;
        holder.mMovieName.setText(movieName);
        holder.mMovieType.setText(movieType);
        holder.mSeason.setText(movieSeason);
        holder.mEpisode.setText(movieEpisode);
        holder.mEpisodeName.setText(movieEpisodeName);
        holder.mTimeStamp.setText(movieTimestamp);
        holder.mRating.setNumStars(Integer.parseInt(movieRating)); //Need to change and refactor going forward


    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }


    public class  ViewHolder extends RecyclerView.ViewHolder{

        public int mId;
        public final TextView mMovieName;
        public final TextView mMovieType;
        public final TextView mSeason;
        public final TextView mEpisode;
        public final TextView mEpisodeName;
        public final TextView mTimeStamp;
        public final RatingBar mRating;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mMovieName = (TextView) itemView.findViewById(R.id.textView_movie_name);
            mMovieType = (TextView) itemView.findViewById(R.id.textView_movie_type);
            mSeason = (TextView) itemView.findViewById(R.id.textView_season);
            mEpisode = (TextView) itemView.findViewById(R.id.textView_episode);
            mEpisodeName = (TextView) itemView.findViewById(R.id.textView_episode_name);
            mTimeStamp = (TextView) itemView.findViewById(R.id.textView_timestamp);
            mRating = (RatingBar) itemView.findViewById(R.id.ratingBar_movie_rating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }
    
}
