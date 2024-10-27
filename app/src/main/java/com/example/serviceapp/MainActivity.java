package com.example.serviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button play, pause, next;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video = (VideoView) findViewById(R.id.videoView);
        video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.puppy);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        next = (Button) findViewById(R.id.next);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == play) {
            //startService(new Intent(this, NewService.class));
            video.start();
        } else if (v == pause) {

            //stopService(new Intent(this, NewService.class));
            video.pause();
        }
    }
}