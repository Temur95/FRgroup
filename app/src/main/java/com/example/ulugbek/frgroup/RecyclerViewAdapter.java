package com.example.ulugbek.frgroup;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mSubtitles = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImages, ArrayList<String> mTitles, ArrayList<String> mSubtitles) {
        this.mImages = mImages;
        this.mTitles = mTitles;
        this.mSubtitles = mSubtitles;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.imgView);
                
        holder.cardTitle.setText(mTitles.get(position));
        holder.cardSubtitle.setText(mSubtitles.get(position));

        holder.parentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked"+mTitles.get(position));

                Intent intent = new Intent(mContext,ProductActivity.class);
                intent.putExtra("image_url",mImages.get(position));
                intent.putExtra("image_desc",mTitles.get(position));
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgView;
        TextView cardTitle,cardSubtitle;
        CardView parentCardView;

        public ViewHolder(View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.cardView_image);
            cardTitle = itemView.findViewById(R.id.cardView_title);
            cardSubtitle = itemView.findViewById(R.id.cardView_subtitle);
            parentCardView = itemView.findViewById(R.id.parent_cardViewLayout);

        }
    }
}
