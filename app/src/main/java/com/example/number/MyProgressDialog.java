package com.example.number;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyProgressDialog extends Dialog {
    ImageView ivLoading;
    TextView tvLoading;
    private Context context;
    private int resId;
    private String content;
    private AnimationDrawable animationDrawable;

    public MyProgressDialog(Context context, String content, int id) {
        super(context);
        this.context = context;
        this.content = content;
        this.resId = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(context).inflate(R.layout.progress_dialog,null);
        setContentView(view);
        setCanceledOnTouchOutside(true);

        ivLoading = findViewById(R.id.iv_loading);
        tvLoading = findViewById(R.id.tv_loading);
        if(resId == 0){
            ivLoading.setBackgroundDrawable(null);
        }else{
            ivLoading.setBackgroundResource(resId);
        }
        animationDrawable = (AnimationDrawable) ivLoading.getBackground();
        ivLoading.post(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        });
        tvLoading.setText(content);
    }
}
