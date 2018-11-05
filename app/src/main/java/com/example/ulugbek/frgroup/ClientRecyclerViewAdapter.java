package com.example.ulugbek.frgroup;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ClientRecyclerViewAdapter extends RecyclerView.Adapter<ClientRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mSubtitles = new ArrayList<>();
    private Context mContext;

    public ClientRecyclerViewAdapter(Context mContext,ArrayList<String> mImages, ArrayList<String> mTitles, ArrayList<String> mSubtitles) {
        this.mImages = mImages;
        this.mTitles = mTitles;
        this.mSubtitles = mSubtitles;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_client,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.imageClient);

        holder.titleClient.setText(mTitles.get(position));
        holder.subtitleClient.setText(mSubtitles.get(position));

        holder.clientCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,ActivityClientInfo.class);
                intent.putExtra("image_url",mImages.get(position));
                intent.putExtra("titles",mTitles.get(position));
                intent.putExtra("subtitles",mSubtitles.get(position));
                mContext.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageClient;
        TextView titleClient;
        TextView subtitleClient;
        CardView clientCardView;


        public ViewHolder(View itemView){
            super(itemView);
            imageClient = itemView.findViewById(R.id.imgView_ClientCardView);
            titleClient = itemView.findViewById(R.id.title_ClientCardView);
            subtitleClient = itemView.findViewById(R.id.subtitle_ClientCardView);
            clientCardView = itemView.findViewById(R.id.cardView_Client);

        }

    }



}
