package com.example.infomusik;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infomusik.ViewHolder.NewsViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class news extends AppCompatActivity {

    private RecyclerView mPeopleRV;
    private DatabaseReference mDatabase;

    private FirebaseRecyclerAdapter<newsDb, NewsViewHolder> mPeopleRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        setTitle("News");

        //"News" here will reflect what you have called your database in Firebase.
        mDatabase = FirebaseDatabase.getInstance().getReference().child("News");
        mDatabase.keepSynced(true);

        mPeopleRV = (RecyclerView) findViewById(R.id.myRecycleView);

        DatabaseReference personsRef = FirebaseDatabase.getInstance().getReference().child("News");
        Query personsQuery = personsRef.orderByKey();

        mPeopleRV.hasFixedSize();
        mPeopleRV.setLayoutManager(new LinearLayoutManager(this));
        onStart();
    }

        @Override
        protected void onStart () {
            super.onStart();
            mPeopleRVAdapter = new FirebaseRecyclerAdapter<newsDb, NewsViewHolder>
                    (newsDb.class, R.layout.content_news, NewsViewHolder.class, mDatabase) {
                @Override
                protected void populateViewHolder(NewsViewHolder NewsViewHolder, final newsDb model, int position) {

                    NewsViewHolder.setTitle(model.getTitle());
                    NewsViewHolder.setDesc(model.getDesc());
                    NewsViewHolder.setUrl(model.getUrl());
                    NewsViewHolder.setImage(getApplicationContext().getApplicationContext(), model.getImage());

                    RecyclerView fab = findViewById(R.id.myRecycleView);
                    NewsViewHolder.setOnClickListener(new NewsViewHolder.ClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(model.getUrl()));
                            startActivity(intent);
                        }

                        @Override
                        public void onItemLongClick(View view, int position) {

                        }
                    });




                }
            };
            mPeopleRV.setAdapter(mPeopleRVAdapter);

    }




}
