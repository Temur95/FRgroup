package com.example.ulugbek.frgroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ActivityDealerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_info);


        initComingIntent();
    }

    private void initComingIntent(){

        if (getIntent().hasExtra("image_url")&&getIntent().hasExtra("titles")&&getIntent().hasExtra("subtitles")){

            String image_url = getIntent().getStringExtra("image_url");
            String titles = getIntent().getStringExtra("titles");
            String subtitles = getIntent().getStringExtra("subtitles");


            setImageText(image_url,titles,subtitles);
        }

    }


    private void setImageText(String image_url, String titles, String subtitles){

        TextView dealerName = findViewById(R.id.dealerName_DealerInfo);
        dealerName.setText(titles);
        TextView dealerAddress = findViewById(R.id.dealerAddress_DealerInfo);
        dealerAddress.setText(subtitles);
        ImageView dealerImage = findViewById(R.id.imgView_DealerInfo);

        Glide.with(this)
                .asBitmap()
                .load(image_url)
                .into(dealerImage);


    }
}
