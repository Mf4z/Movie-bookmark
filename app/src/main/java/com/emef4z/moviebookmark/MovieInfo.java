package com.emef4z.moviebookmark;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieInfo implements Parcelable {
    private int mId;
    private String mMovieType;
    private String mSeason;
    private String mEpisode;
    private String mEpisodeName;
    private String mTimeStamp;
    private String mRating;


    public MovieInfo(int mId, String mMovieType, String mSeason, String mEpisode, String mEpisodeName,String mTimeStamp, String mRating) {
        this.mId = mId;
        this.mMovieType = mMovieType;
        this.mSeason = mSeason;
        this.mEpisode = mEpisode;
        this.mEpisodeName = mEpisodeName;
        this.mTimeStamp = mTimeStamp;
        this.mRating = mRating;
    }

    private MovieInfo(Parcel source) {

        mId = source.readInt();
        mMovieType = source.readString();
        mSeason = source.readString();
        mEpisode = source.readString();
        mEpisodeName = source.readString();
        mTimeStamp = source.readString();
        mRating = source.readString();

    }


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmMovieType() {
        return mMovieType;
    }

    public void setmMovieType(String mMovieType) {
        this.mMovieType = mMovieType;
    }

    public String getmSeason() {
        return mSeason;
    }

    public void setmSeason(String mSeason) {
        this.mSeason = mSeason;
    }

    public String getmEpisode() {
        return mEpisode;
    }

    public void setmEpisode(String mEpisode) {
        this.mEpisode = mEpisode;
    }

    public String getmEpisodeName() {
        return mEpisodeName;
    }

    public void setmEpisodeName(String mEpisodeName) {
        this.mEpisodeName = mEpisodeName;
    }

    public String getmRating() {
        return mRating;
    }

    public void setmRating(String mRating) {
        this.mRating = mRating;
    }

    public String getmTimeStamp() {
        return mTimeStamp;
    }

    public void setmTimeStamp(String mTimeStamp) {
        this.mTimeStamp = mTimeStamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(mId);
        dest.writeString(mMovieType);
        dest.writeString(mSeason);
        dest.writeString(mEpisode);
        dest.writeString(mEpisodeName);
        dest.writeString(mTimeStamp);
        dest.writeString(mRating);
    }

    public static final Parcelable.Creator<MovieInfo> CREATOR =
            new Parcelable.Creator<MovieInfo>() {
                @Override
                public MovieInfo createFromParcel(Parcel source) {
                    return new MovieInfo(source);
                }

                @Override
                public MovieInfo[] newArray(int size) {
                    return new MovieInfo[size];
                }
            };
}
