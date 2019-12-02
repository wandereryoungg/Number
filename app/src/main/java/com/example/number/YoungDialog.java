package com.example.number;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class YoungDialog extends Dialog {

    public YoungDialog(@NonNull Context context) {
        super(context);
    }

    public YoungDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder{
        private View view;
        private ImageView dialogIcon;
        private TextView dialogTitle;
        private TextView dialogMessage;
        private Button btnDone;
        private Button btnAgain;
        private View.OnClickListener doneOnClickListener;
        private View.OnClickListener againOnClickListener;
        private YoungDialog youngDialog;

        public Builder(Context context){
            youngDialog = new YoungDialog(context);
            //youngDialog = new YoungDialog(context,R.style.Theme_AppCompat_Dialog);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.young_dialog,null,false);
            //youngDialog.addContentView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            dialogIcon = view.findViewById(R.id.dialog_icon);
            dialogTitle = view.findViewById(R.id.dialog_title);
            dialogMessage = view.findViewById(R.id.dialog_message);
            btnDone = view.findViewById(R.id.button_done);
            btnAgain = view.findViewById(R.id.button_again);
        }

        public Builder setIcon(int resId){
            dialogIcon.setImageResource(resId);
            return this;
        }

        public Builder setIcon(Bitmap bitmap){
            dialogIcon.setImageBitmap(bitmap);
            return this;
        }

        public Builder setTitle(@NonNull String title){
            dialogTitle.setText(title);
            dialogTitle.setVisibility(View.VISIBLE);
            return this;
        }

        public Builder setMessage(@NonNull String message){
            dialogMessage.setText(message);
            return this;
        }

        public Builder setPositiveButton(@NonNull String text, View.OnClickListener onClickListener){
            btnDone.setText(text);
            doneOnClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(@NonNull String text, View.OnClickListener onClickListener){
            btnAgain.setText(text);
            againOnClickListener = onClickListener;
            return this;
        }

        public YoungDialog create(){
            btnDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    youngDialog.dismiss();
                    doneOnClickListener.onClick(v);
                }
            });
            btnAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    youngDialog.dismiss();
                    againOnClickListener.onClick(v);
                }
            });
            /*
            btnDone.setOnClickListener(doneOnClickListener);
            btnAgain.setOnClickListener(againOnClickListener);
             */
            youngDialog.setContentView(view);
            youngDialog.setCancelable(false);
            youngDialog.setCanceledOnTouchOutside(false);
            return youngDialog;
        }

    }
}
