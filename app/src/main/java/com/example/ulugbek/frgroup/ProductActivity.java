package com.example.ulugbek.frgroup;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProductActivity extends AppCompatActivity {

    private static final String TAG = "started" ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        getIncomingIntent();


    }

    private void getIncomingIntent(){

        Log.d(TAG, "getIncomingIntent: intentfound");
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_desc")){
            Log.d(TAG, "getIncomingIntent: imageview and text attached");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageDescrp = getIntent().getStringExtra("image_desc");

            setImage(imageUrl,imageDescrp);
        }
        
    }

    private void setImage(String imageUrl,String imageDescp){

        TextView name = findViewById(R.id.textView_descrp);
        name.setText(imageDescp);

        ImageView image = findViewById(R.id.imageView_productView);

        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

    }
}
