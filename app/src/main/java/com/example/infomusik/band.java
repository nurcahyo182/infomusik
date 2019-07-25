package com.example.infomusik;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class band extends AppCompatActivity {

    private RecyclerView mBandDblist;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Band Terbaik");
        mDatabase.keepSynced(true);

        mBandDblist = (RecyclerView) findViewById(R.id.myrecycleview);
        mBandDblist.setHasFixedSize(true);
        mBandDblist.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<bandDb, BandDbViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<bandDb, BandDbViewHolder>
                (bandDb.class, R.layout.blog_row, BandDbViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(BandDbViewHolder viewHolder, bandDb model, int position) {

                viewHolder.setFoto(getApplicationContext(), model.getFoto());
                viewHolder.setInfo(model.getInfo());
            }

        };
        mBandDblist.setAdapter(firebaseRecyclerAdapter);
    }


    public static class BandDbViewHolder extends RecyclerView.ViewHolder
    {
        View mview;



        public BandDbViewHolder(View itemView){
            super(itemView);
            mview = itemView;
        }

        public void setInfo(String info) {
            TextView post_desc =(TextView) mview.findViewById(R.id.post_desc);
            post_desc.setText(info);
        }


        public void setFoto(Context ctx, String foto) {
            ImageView post_image =(ImageView) mview.findViewById(R.id.post_image);
            Picasso.with(ctx).load(foto).into(post_image);
        }
    }
}
