package com.example.number;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyProgressDialog extends ProgressBar {
    ImageView ivLoading;
    TextView tvLoading;
    private AnimationDrawable animationDrawable;

    public MyProgressDialog(Context context, String content, int id) {
        super(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.progress_dialog,null);
        ivLoading = findViewById(R.id.iv_loading);
        tvLoading = findViewById(R.id.tv_loading);
        if(id == 0){
            ivLoading.setBackgroundDrawable(null);
        }else{
            ivLoading.setImageResource(id);
        }
        animationDrawable = (AnimationDrawable) ivLoading.getBackground();
        ivLoading.post(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        });

    }





}
