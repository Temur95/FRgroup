package com.example.ulugbek.frgroup;

import android.content.Context;
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

public class ClientFragment extends Fragment {

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mSubtitles = new ArrayList<>();

    private String[] mTitleString = {"FR TRade","Halal","Coca Cola","SHSJS","YUYUYU","RC Cola"};
    private String[] mSubTitleString = {"Address","Yakkasaroy","Olmazor","Shayxontohur","Uchtepa","Sergeli"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.client_fragment,container,false);

        initBitMaps();

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_ClientFragmentCard);
        recyclerView.setNestedScrollingEnabled(false);
        ClientRecyclerViewAdapter adapter = new ClientRecyclerViewAdapter(this.getActivity(),mImages,mTitles,mSubtitles);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        recyclerView.setAdapter(adapter);


        return rootView;
    }

    private void initBitMaps(){

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("FR Trade");
        mSubtitles.add("Address");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Halal");
        mSubtitles.add("Yakkasaroy");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Coca Cola");
        mSubtitles.add("Sergeli");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("RC Cola");
        mSubtitles.add("YangiYo'l");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("Pankie");
        mSubtitles.add("Olmazor");

        mImages.add("http://spiders.uz/img/sellers/1533750879.png");
        mTitles.add("M&M's");
        mSubtitles.add("Uchtepa");


    }

}
