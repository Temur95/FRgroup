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

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DealerRecyclerViewAdapter extends RecyclerView.Adapter<DealerRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mSubtitles = new ArrayList<>();
    private Context mContext;

    public DealerRecyclerViewAdapter(Context mContext,ArrayList<String> mImages, ArrayList<String> mTitle, ArrayList<String> mSubtitles) {
        this.mImages = mImages;
        this.mTitle = mTitle;
        this.mSubtitles = mSubtitles;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_dealer,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.mDealerImageView);
        holder.mTitle.setText(mTitle.get(position));
        holder.mSubtitles.setText(mSubtitles.get(position));

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,DealerRecyclerViewAdapter.class);
                intent.putExtra("image_url",mImages.get(position));
                intent.putExtra("titles",mTitle.get(position));
                intent.putExtra("subtitles",mSubtitles.get(position));
                mContext.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mDealerImageView;
        TextView mTitle,mSubtitles;
        CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mDealerImageView = itemView.findViewById(R.id.imgView_DealerCardView);
            mTitle = itemView.findViewById(R.id.title_DealerCardView);
            mSubtitles = itemView.findViewById(R.id.subtitle_DealerCardView);
            mCardView = itemView.findViewById(R.id.cardView_dealer);


        }
    }
}
