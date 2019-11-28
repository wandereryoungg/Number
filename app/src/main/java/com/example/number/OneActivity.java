package com.example.number;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OneActivity extends AppCompatActivity {

    private ImageView ivFrame;
    private Button btnDemo;
    MediaPlayer mediaPlayer;
    public MyProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        ivFrame = findViewById(R.id.iv_frame);
        btnDemo = findViewById(R.id.btn_demo);
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new MyProgressDialog(OneActivity.this,"loading",R.drawable.frame1);
                progressDialog.show();
            }
        });

        if(MainActivity.isPlay == true){
            playMusic();
        }
    }

    private void playMusic() {
        mediaPlayer = MediaPlayer.create(this,R.raw.music1);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
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
