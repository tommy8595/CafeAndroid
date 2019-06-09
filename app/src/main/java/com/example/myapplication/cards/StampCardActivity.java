package com.example.myapplication.cards;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.alexzh.circleimageview.CircleImageView;
import com.alexzh.circleimageview.ItemSelectedListener;
import com.example.myapplication.R;
import com.example.myapplication.databinding.OnlyStampCardLayoutBinding;

public class StampCardActivity extends AppCompatActivity
        implements ItemSelectedListener {

    Toolbar mToolBar;
    TextView mTvTitleBar;
    OnlyStampCardLayoutBinding mStampBinding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStampBinding = DataBindingUtil.setContentView(this,R.layout.stamp_card);

        mToolBar = (Toolbar)findViewById(R.id.toolBar);
        mToolBar.setTitle("");
        mToolBar.setNavigationIcon(R.drawable.ic_left_arrow);
        setSupportActionBar(mToolBar);

        mTvTitleBar = (TextView)findViewById(R.id.tvTitleBar);
        mTvTitleBar.setText(getResources().getString(R.string.title_stamp_card));

//        mStampBinding.checktop1.setSelected(false);
//        mStampBinding.checktop2.setSelected(false);
//        mStampBinding.checktop3.setSelected(false);
//        mStampBinding.checktop4.setSelected(false);
//
//        mStampBinding.checkdown1.setSelected(false);
//        mStampBinding.checkdown2.setSelected(false);
//        mStampBinding.checkdown3.setSelected(false);
//        mStampBinding.checkdown4.setSelected(false);

        mStampBinding.checktop1.setOnItemSelectedClickListener(this);
        mStampBinding.checktop2.setOnItemSelectedClickListener(this);
        mStampBinding.checktop3.setOnItemSelectedClickListener(this);
        mStampBinding.checktop4.setOnItemSelectedClickListener(this);

        mStampBinding.checkdown1.setOnItemSelectedClickListener(this);
        mStampBinding.checkdown2.setOnItemSelectedClickListener(this);
        mStampBinding.checkdown3.setOnItemSelectedClickListener(this);
        mStampBinding.checkdown4.setOnItemSelectedClickListener(this);
    }

    @Override
    public void onSelected(View view) {

    }

    @Override
    public void onUnselected(View view) {

    }
}
