package com.emef4z.moviebookmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WatchingFragment extends Fragment {

    private MovieBookmarkOpenHelper mOpenHelper;
    private RecyclerView mRecyclerItems;
    private LinearLayoutManager mLinearLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mOpenHelper = new MovieBookmarkOpenHelper(getContext());

        View rootView = inflater.inflate(R.layout.display_list, container, false);


        return rootView;
    }

    @Override
    public void onDestroyView() {
        mOpenHelper.close();
        super.onDestroyView();
    }


    private void initializeDisplayContent(View rootView){

        mRecyclerItems = (RecyclerView)rootView.findViewById(R.id.recyclerView_list);
        mLinearLayoutManager = new LinearLayoutManager(getContext());

    }
}
