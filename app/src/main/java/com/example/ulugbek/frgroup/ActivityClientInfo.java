package com.example.ulugbek.frgroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ActivityClientInfo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_info);


        initIncomingIntent();

    }

    private void initIncomingIntent(){

        if (getIntent().hasExtra("image_url")&&getIntent().hasExtra("titles")&&getIntent().hasExtra("subtitles")){

            String image_url = getIntent().getStringExtra("image_url");
            String titles = getIntent().getStringExtra("titles");
            String subtitles = getIntent().getStringExtra("subtitles");


            setImageTitles(image_url,titles,subtitles);
        }

    }

    private void setImageTitles(String image_url, String titles, String subtitles){

        TextView nameClient = findViewById(R.id.nameClient_ClintInfo);
        nameClient.setText(titles);

        TextView address = findViewById(R.id.txtClinetAddres_ClintInfo);
        address.setText(subtitles);

        ImageView imageView = findViewById(R.id.imgView_ClientInfo);

        Glide.with(this)
                .asBitmap()
                .load(image_url)
                .apply(new RequestOptions().override(200, 100))
                .into(imageView);





    }

}
