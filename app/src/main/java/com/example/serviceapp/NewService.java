package com.example.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class NewService extends Service {

    private MediaPlayer player;

//    public int onStartCommand(Intent intent, int flags, int startId){
//        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
//    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
        player = MediaPlayer.create(this, R.raw.puppy);
        player.setLooping(false);
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();

        player.start();

        return START_STICKY;
    }

    public void onDestroy(){
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();

        player.stop();
    }
}
