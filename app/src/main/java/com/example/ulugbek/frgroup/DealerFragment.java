package com.example.ulugbek.frgroup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DealerFragment extends Fragment {

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mSubtitles = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dealer_fragment,container,false);

        initBItmAps();

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_DealerFragmentCard);
        recyclerView.setNestedScrollingEnabled(false);
        DealerRecyclerViewAdapter adapter = new DealerRecyclerViewAdapter(this.getActivity(),mImages,mTitles,mSubtitles);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void initBItmAps(){

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer1");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer2");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer3");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer4");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer5");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer6");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer7");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer8");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Dealer9");
        mSubtitles.add("Address");


    }

}
