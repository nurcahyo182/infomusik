package com.example.infomusik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class detailevent extends AppCompatActivity {

    private TextView txt_title,txt_deskripsi;
    private ImageView imageView;
    private FirebaseDatabase mFireDatabase;
    private DatabaseReference mDatabase;
    String eventId="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailevent);

        mFireDatabase = FirebaseDatabase.getInstance();
        mDatabase = mFireDatabase.getReference("event");

        txt_title = findViewById(R.id.detail_info_event);
        txt_deskripsi = findViewById(R.id.detail_deskripsi_event);
        imageView = findViewById(R.id.detail_img_event);


        if (getIntent() != null)
            eventId = getIntent().getStringExtra("Event");
        if (!eventId.isEmpty()){
            getDetailEvent(eventId);
        }


        }

    private void getDetailEvent(String eventId) {

        mDatabase.child(eventId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                final eventDb event = dataSnapshot.getValue(eventDb.class);
                txt_title.setText(event.getInfo());
                txt_deskripsi.setText(event.getDesc());

                Picasso.with(getBaseContext()).load(event.getFoto())
                        .fit()
                        .into(imageView);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });

    }
}