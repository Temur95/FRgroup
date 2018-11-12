package com.example.ulugbek.frgroup;

import android.app.Fragment;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;


public class HomeFragment extends android.support.v4.app.Fragment {

    int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3};


    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mSubtitles = new ArrayList<>();
    private ArrayList<String> mImageUri = new ArrayList<>();
    private LinearLayoutManager mLayoutManager;
    private DrawerLayout mDrawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_fragment,container,false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_mainFrameLayout);
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this.getActivity(),mImageUri,mTitles,mSubtitles);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        recyclerView.setAdapter(adapter);

        initImageBitMaps();

        //CarouselImageView declaring
        CarouselView carouselView = rootView.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        FlingAnimation fling = new FlingAnimation(recyclerView,DynamicAnimation.SCALE_Y);
                fling.setStartVelocity(-2000)
                .setMinValue(-200).setMaxValue(2000)
                .setFriction(1.1f)
                .start();


        mDrawerLayout = rootView.findViewById(R.id.drawerLayout);


        return rootView;
    }



    private void initImageBitMaps(){

        mImageUri.add("https://pbs.twimg.com/profile_images/692038602088280064/xS4CV9Sc_400x400.jpg");
        mTitles.add("First");
        mSubtitles.add("fisrt");

        mImageUri.add("https://pbs.twimg.com/profile_images/692038602088280064/xS4CV9Sc_400x400.jpg");
        mTitles.add("2Nd");
        mSubtitles.add("2nd");

        mImageUri.add("https://pbs.twimg.com/profile_images/692038602088280064/xS4CV9Sc_400x400.jpg");
        mTitles.add("3RD");
        mSubtitles.add("3rd");

        mImageUri.add("https://pbs.twimg.com/profile_images/692038602088280064/xS4CV9Sc_400x400.jpg");
        mTitles.add("4TH");
        mSubtitles.add("4th");

        mImageUri.add("https://pbs.twimg.com/profile_images/692038602088280064/xS4CV9Sc_400x400.jpg");
        mTitles.add("%TH");
        mSubtitles.add("5th");

        mImageUri.add("https://pbs.twimg.com/profile_images/692038602088280064/xS4CV9Sc_400x400.jpg");
        mTitles.add("6TH");
        mSubtitles.add("6th");

        mImageUri.add("https://pbs.twimg.com/profile_images/692038602088280064/xS4CV9Sc_400x400.jpg");
        mTitles.add("7TH");
        mSubtitles.add("7th");

        mImageUri.add("https://goo.gl/images/WvBkwY");
        mTitles.add("8TH");
        mSubtitles.add("8th");


        mTitles.add("9TH");
        mSubtitles.add("9th");

    }


    //CarouselImageView setting position
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}
