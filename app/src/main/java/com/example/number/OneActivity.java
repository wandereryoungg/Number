package com.example.number;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class OneActivity extends AppCompatActivity {

    private ImageView ivFrame;
    private Button btnDemo;
    MediaPlayer mediaPlayer;
    public MyProgressDialog progressDialog;
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;
    int imgX;
    int imgY;
    int i = 1;
    int widthPixels;
    int heightPixels;
    int type = 0;
    float scaleWidth;
    float scaleHeight;
    Timer touchTimer = null;
    Bitmap bitmap;
    boolean typeDialog = true;
    LinearLayout linearLayout = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

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

        init();
    }

    private void init() {
        ivFrame = findViewById(R.id.iv_frame);
        linearLayout = findViewById(R.id.linearLayout);
        widthPixels = this.getResources().getDisplayMetrics().widthPixels;
        heightPixels = this.getResources().getDisplayMetrics().heightPixels;
        scaleWidth = widthPixels/720;
        scaleHeight = heightPixels/1280;
        try {
            InputStream is = getResources().getAssets().open("on1_1.png");
            bitmap = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ivFrame.getLayoutParams();
        layoutParams.width = (int) (bitmap.getWidth()*scaleWidth);
        layoutParams.height = (int) (bitmap.getHeight()*scaleHeight);
        ivFrame.setLayoutParams(layoutParams);
        loadImg(1);
        final int ivWidth = (int) (bitmap.getWidth()*scaleWidth);
        final int ivHeight = (int) (bitmap.getHeight()*scaleHeight);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        y1 = event.getY();
                        imgX = ivFrame.getLeft();
                        imgY = ivFrame.getTop();
                        if(x1>=imgX&&x1<=imgX+ivWidth&&y1>=imgY&&y1<=imgY+ivHeight){
                            type = 1;
                        }else{
                            type = 0;
                        }
                        break;
                    case  MotionEvent.ACTION_MOVE:
                        x2 = event.getX();
                        y2 = event.getY();
                        imgX = ivFrame.getLeft();
                        imgY = ivFrame.getTop();
                        if(type == 1){
                            if(x2>=imgX&&x2<=imgX+ivWidth){
                                if(y2>imgY&&y2<=imgY+ivHeight/24){
                                    loadImg(1);
                                }else if(y2<=imgY+ivHeight/24*2){
                                    loadImg(2);
                                }else if(y2<=imgY+ivHeight/24*3){
                                    loadImg(3);
                                }else if(y2<=imgY+ivHeight/24*4){
                                    loadImg(4);
                                }else if(y2<=imgY+ivHeight/24*5){
                                    loadImg(5);
                                }else if(y2<=imgY+ivHeight/24*6){
                                    loadImg(6);
                                }else if(y2<=imgY+ivHeight/24*7){
                                    loadImg(7);
                                }else if(y2<=imgY+ivHeight/24*8){
                                    loadImg(8);
                                }else if(y2<=imgY+ivHeight/24*9){
                                    loadImg(9);
                                }else if(y2<=imgY+ivHeight/24*10){
                                    loadImg(10);
                                }else if(y2<=imgY+ivHeight/24*11){
                                    loadImg(11);
                                }else if(y2<=imgY+ivHeight/24*12){
                                    loadImg(12);
                                }else if(y2<=imgY+ivHeight/24*13){
                                    loadImg(13);
                                }else if(y2<=imgY+ivHeight/24*14){
                                    loadImg(14);
                                }else if(y2<=imgY+ivHeight/24*15){
                                    loadImg(15);
                                }else if(y2<=imgY+ivHeight/24*16){
                                    loadImg(16);
                                }else if(y2<=imgY+ivHeight/24*17){
                                    loadImg(17);
                                }else if(y2<=imgY+ivHeight/24*18){
                                    loadImg(18);
                                }else if(y2<=imgY+ivHeight/24*19){
                                    loadImg(19);
                                }else if(y2<=imgY+ivHeight/24*20){
                                    loadImg(20);
                                }else if(y2<=imgY+ivHeight/24*21){
                                    loadImg(21);
                                }else if(y2<=imgY+ivHeight/24*22){
                                    loadImg(22);
                                }else if(y2<=imgY+ivHeight/24*23){
                                    loadImg(23);
                                }else if(y2<=imgY+ivHeight/24*24){
                                    loadImg(24);
                                }else{
                                    type = 0;
                                }
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        type = 0;
                        if(touchTimer !=null){
                            touchTimer.cancel();
                            touchTimer = null;
                        }
                        touchTimer = new Timer();
                        touchTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Message message = new Message();
                                        message.what = 1;
                                        handler.sendMessage(message);
                                    }
                                }).start();
                            }
                        },300,200);
                        break;

                }
                return true;
            }

        });
    }

    private void loadImg(int j) {
        i = j;
        if(i<25){
            String name = "on1_"+i;
            i++;
            int imgId = getResources().getIdentifier(name,"drawable","com.example.number");
            ivFrame.setBackgroundResource(imgId);
        }
        if(j == 24){
            if(typeDialog){
                dialog();
            }
        }
    }

    private void dialog() {
        /*
        typeDialog = false;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("太棒了！书写完成- -");
        builder.setPositiveButton("完成", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                typeDialog = true;
                dialog.dismiss();
                finish();
            }
        });
        builder.setNegativeButton("再来一次", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                typeDialog = true;
                dialog.dismiss();
                loadImg(1);
            }
        });
        builder.show();
         */
        typeDialog = false;
        final YoungDialog youngDialog = new YoungDialog.Builder(this).setIcon(R.drawable.dialog)
                .setTitle("提示")
                .setMessage("太棒了，完成了书写- -")
                .setPositiveButton("完成", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        typeDialog = true;
                        finish();
                    }
                })
                .setNegativeButton("再来一次", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        typeDialog = true;
                        loadImg(1);
                    }
                }).create();
        youngDialog.show();
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
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    loadImgBack();
                    break;
            }
        }
    };

    private void loadImgBack() {
        if(i == 25){
            if(touchTimer!=null){
                touchTimer.cancel();
                touchTimer = null;
            }
        }else if(i <25){
            if(i >1){
                i--;
            }else if(i==1){
                i=1;
                if(touchTimer !=null){
                    touchTimer.cancel();
                    touchTimer = null;
                }
            }
            String name = "on1_"+i;
            int imgId = getResources().getIdentifier(name,"drawable","com.example.number");
            ivFrame.setBackgroundResource(imgId);
        }
    }
}
