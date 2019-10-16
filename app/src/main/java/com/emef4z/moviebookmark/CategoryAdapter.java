package com.emef4z.moviebookmark;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    final int PAGE_COUNT = 3;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0 ){

            return new TopMoviesFragment();

        }else if(position == 1){

            return new WatchingFragment();

        }else {

            return new TopSeriesFragment();
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {

            return mContext.getString(R.string.tab_top_movies);

        }else if (position == 1){

            return mContext.getString(R.string.tab_watching);

        }else {

            return mContext.getString(R.string.tab_top_series);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
