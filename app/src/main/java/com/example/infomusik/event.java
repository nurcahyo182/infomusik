package com.example.infomusik;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

    private FirebaseRecyclerAdapter<eventDb, EventViewHolder> firebaseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("event");
        mDatabase.keepSynced(true);


        mEventlist = (RecyclerView) findViewById(R.id.myrecycleviewEvent);
        mEventlist.setHasFixedSize(true);
        mEventlist.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<eventDb, EventViewHolder>
                (eventDb.class, R.layout.content_event, EventViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(EventViewHolder viewHolder, eventDb model, final int position) {

                viewHolder.setFoto(getApplicationContext(), model.getFoto());
                viewHolder.setInfo(model.getInfo());

                viewHolder.cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(event.this, detailevent.class);
                        intent.putExtra("Event", firebaseRecyclerAdapter.getRef(position).getKey());
                        startActivity(intent);



                    }
                });

            }
        };
        mEventlist.setAdapter(firebaseRecyclerAdapter);
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder
    {
        View mview, cardview;

        public EventViewHolder(View itemView){
            super(itemView);
            mview = itemView;
            cardview = itemView.findViewById(R.id.cv_content_event);
        }

        public void setFoto(Context ctx, String foto) {
            ImageView post_foto_event =(ImageView) mview.findViewById(R.id.post_foto_event);
            Picasso.with(ctx).load(foto).into(post_foto_event);
        }



        public void setInfo(String info) {
            TextView post_info_event =(TextView) mview.findViewById(R.id.post_info_event);
            post_info_event.setText(info);
        }


    }
}
