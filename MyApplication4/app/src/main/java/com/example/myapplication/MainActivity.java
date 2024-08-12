package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {
    Button B1,B2,B3,B4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1 = findViewById(R.id.button1);
        B2 = findViewById(R.id.button2) ;
        B3 = findViewById(R.id.button3) ;
        B4 = findViewById(R.id.button4) ;
        B1.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(getApplicationContext(), MyService.class);
            serviceIntent.putExtra("music_resource", R.raw.a7x);
            startService(serviceIntent);
        });
        B2.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(getApplicationContext(), MyService.class);
            serviceIntent.putExtra("music_resource", R.raw.bullet);
            startService(serviceIntent);
        });
        B4.setOnClickListener(view -> {
            Intent serviceIntent = new Intent(getApplicationContext(), MyService.class);
            serviceIntent.putExtra("music_resource", R.raw.nwm);
            startService(serviceIntent);
        });

        B3.setOnClickListener(view -> stopService(new Intent(getApplicationContext(), MyService.class)));
    }
}
