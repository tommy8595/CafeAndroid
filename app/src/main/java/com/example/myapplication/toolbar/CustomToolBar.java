package com.example.myapplication.toolbar;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public final class CustomToolBar {

//    public CustomToolBar(AppCompatActivity activity){
//        Toolbar mToolBar = (Toolbar)activity.findViewById(R.id.toolBar);
//        mToolBar.setTitle("");
//        mToolBar.setNavigationIcon(R.drawable.ic_left_arrow);
//        activity.setSupportActionBar(mToolBar);
//
//        TextView mTvTitleBar = (TextView)activity.findViewById(R.id.tvTitleBar);
//        mTvTitleBar.setText(activity.getResources().getString(R.string.title_stamp_card));
//
//        activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.colorBrown,null));
//    }
    private CustomToolBar(){
    }
    public static Toolbar loadCustomerToolBar(@NonNull AppCompatActivity activity, @NonNull String title, @Nullable Drawable icon){
        Toolbar mToolBar = (Toolbar)activity.findViewById(R.id.toolBar);
        mToolBar.setTitle("");
        if(icon != null){
            mToolBar.setNavigationIcon(icon);
        }
        activity.setSupportActionBar(mToolBar);
        //
        TextView mTvTitleBar = (TextView)activity.findViewById(R.id.tvTitleBar);
        mTvTitleBar.setText(title);
        return mToolBar;
    }
}
