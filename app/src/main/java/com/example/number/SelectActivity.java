package com.example.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        iv1 = findViewById(R.id.iv1);
        iv1.setOnClickListener(this);
        if(MainActivity.isPlay == true){
            playMusic();
        }
    }

    private void playMusic() {
        mediaPlayer = MediaPlayer.create(this,R.raw.number_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv1:
                startActivity(new Intent(this,OneActivity.class));
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(MainActivity.isPlay == true){
            playMusic();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer !=null){
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer !=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
