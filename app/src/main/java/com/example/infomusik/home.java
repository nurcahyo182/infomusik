package com.example.infomusik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        //gotoEvent
        ImageView img2 = (ImageView) findViewById(R.id.event);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSubProfile();
            }
            private void goToSubProfile() {
                Intent intent = new Intent(home.this, event.class);
                startActivity(intent);
            }
        });

        //gotoNews
        ImageView img3 = (ImageView) findViewById(R.id.news);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSubProfile();
            }
            private void goToSubProfile() {
                Intent intent = new Intent(home.this, news.class);
                startActivity(intent);
            }
        });

        //gotoPlaylist
        ImageView img4 = (ImageView) findViewById(R.id.playlist);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSubProfile();
            }
            private void goToSubProfile() {
                Intent intent = new Intent(home.this, playlist.class);
                startActivity(intent);
            }
        });

        //gotoBand
        ImageView img5 = (ImageView) findViewById(R.id.band);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSubProfile();
            }
            private void goToSubProfile() {
                Intent intent = new Intent(home.this, band.class);
                startActivity(intent);
            }
        });


    }

}
