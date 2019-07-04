package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    Intent mStartMain = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.loading_screen);

        mStartMain = new Intent(SplashScreenActivity.this,MainActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try{
            if(Thread.currentThread().isInterrupted()){
                finish();
                startActivity(mStartMain);
            }
        }catch (Exception ex){
            Log.d("Exception",ex.getMessage());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        try{
            if(!Thread.currentThread().isInterrupted()){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(2000);
                            startActivity(mStartMain);
                            Thread.currentThread().interrupt();
                            finish();
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                }).start();
            }
        }catch (Exception ex){
            Log.d("Exception",ex.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
