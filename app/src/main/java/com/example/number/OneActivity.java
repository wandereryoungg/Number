package com.example.number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OneActivity extends AppCompatActivity {

    private ImageView ivFrame;
    private Button btnDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        ivFrame = findViewById(R.id.iv_frame);
        btnDemo = findViewById(R.id.btn_demo);
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyProgressDialog progressDialog = new MyProgressDialog(OneActivity.this,"loading",R.drawable.frame1);

            }
        });

    }
}
