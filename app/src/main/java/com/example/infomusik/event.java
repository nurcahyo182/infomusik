package com.example.infomusik;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class event extends AppCompatActivity {

    private RecyclerView mEventlist;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        //fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("event");
        mDatabase.keepSynced(true);


        mEventlist = (RecyclerView) findViewById(R.id.myrecycleviewEvent);
        mEventlist.setHasFixedSize(true);
        mEventlist.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        final FirebaseRecyclerAdapter<eventDb, EventViewHolder>firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<eventDb, EventViewHolder>
                (eventDb.class, R.layout.content_event, EventViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(EventViewHolder viewHolder, eventDb model, int position) {
                viewHolder.setJudul(model.getJudul());
                viewHolder.setKet(model.getKet());
            }
        };
        mEventlist.setAdapter(firebaseRecyclerAdapter);
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder
    {
        View mview;

        public EventViewHolder(View itemView){
            super(itemView);
            mview = itemView;
        }

        public void setJudul(String judul) {
            TextView post_judul_event =(TextView) mview.findViewById(R.id.post_judul_event);
            post_judul_event.setText(judul);
        }

        public void setKet(String ket) {
            TextView post_ket_event =(TextView) mview.findViewById(R.id.post_ket_event);
            post_ket_event.setText(ket);
        }


    }
}
