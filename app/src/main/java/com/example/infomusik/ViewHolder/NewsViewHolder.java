package com.example.infomusik.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infomusik.R;
import com.squareup.picasso.Picasso;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    View mView;
    ImageView imageView;
    TextView post_desc;
    TextView post_title;
    TextView post_url;


    public NewsViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        //listener set on ENTIRE ROW, you may set on individual components within a row.
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());
                return true;
            }
        });

    }

    public void setTitle(String title) {
        TextView post_title = (TextView) mView.findViewById(R.id.post_title);
        post_title.setText(title);
    }

    public void setDesc(String desc) {

    }

    public void setUrl(String url) {

    }
    public void setImage(Context ctx, String image) {
        ImageView post_image = (ImageView) mView.findViewById(R.id.post_image);
        Picasso.with(ctx).load(image).into(post_image);
    }

    private NewsViewHolder.ClickListener mClickListener;

    //Interface to send callbacks...
    public interface ClickListener {
        public void onItemClick(View view, int position);

        public void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(NewsViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;


    }
}
