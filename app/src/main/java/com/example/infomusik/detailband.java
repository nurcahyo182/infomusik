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

public class detailband extends AppCompatActivity {

    private TextView txt_title,txt_deskripsi;
    private ImageView imageView;
    private FirebaseDatabase mFireDatabase;
    private DatabaseReference mDatabase;
    String bandId="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailband);

        mFireDatabase = FirebaseDatabase.getInstance();
        mDatabase = mFireDatabase.getReference("Band Terbaik");

        txt_title = findViewById(R.id.detail_info_band);
        txt_deskripsi = findViewById(R.id.detail_deskripsi_band);
        imageView = findViewById(R.id.detail_img_band);


        if (getIntent() != null)
            bandId = getIntent().getStringExtra("Band Terbaik");
        if (!bandId.isEmpty()){
            getDetailBand(bandId);
        }


    }

    private void getDetailBand(String bandId) {

        mDatabase.child(bandId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                final bandDb band = dataSnapshot.getValue(bandDb.class);
                txt_title.setText(band.getInfo());
                txt_deskripsi.setText(band.getDesc());

                Picasso.with(getBaseContext()).load(band.getFoto())
                        .fit()
                        .into(imageView);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
    }
}
