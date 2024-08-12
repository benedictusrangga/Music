package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    private int musicResource;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service created", Toast.LENGTH_SHORT).show();
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();

        if (intent != null && intent.hasExtra("music_resource")) {
            int newMusicResource = intent.getIntExtra("music_resource", -1);
            if (newMusicResource != -1 && newMusicResource != musicResource) {
                // Stop the previous song
                stopMusic();

                // Start the new song
                musicResource = newMusicResource;
                mediaPlayer = MediaPlayer.create(this, musicResource);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
            }
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show();
        stopMusic();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void stopMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release(); // Release the MediaPlayer resources
        mediaPlayer = null;
    }
}
