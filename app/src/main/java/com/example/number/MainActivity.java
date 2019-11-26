package com.example.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlay;
    private Button btnMute;
    private Button btnAbout;
    MediaPlayer mediaPlayer;
    static boolean isPlay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btn_play);
        btnMute = findViewById(R.id.btn_mute);
        btnAbout = findViewById(R.id.btn_about);
        btnPlay.setOnClickListener(this);
        btnMute.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

        playMusic();
    }

    private void playMusic() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_play:
                startActivity(new Intent(this,SelectActivity.class));
                break;
            case R.id.btn_mute:
                if(isPlay == true){

                }
                break;
            case R.id.btn_about:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }
    }
}
