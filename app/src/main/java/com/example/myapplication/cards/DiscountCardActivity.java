package com.example.myapplication.cards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.toolbar.CustomToolBar;

public class DiscountCardActivity extends AppCompatActivity {

    Toolbar mToolBar;
    TextView mTvTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discount_card);

//        mToolBar = (Toolbar)findViewById(R.id.toolBar);
//        mToolBar.setTitle("");
//        mToolBar.setNavigationIcon(R.drawable.ic_left_arrow);
//        setSupportActionBar(mToolBar);
//
//        mTvTitleBar = (TextView)findViewById(R.id.tvTitleBar);
//        mTvTitleBar.setText(getResources().getString(R.string.title_discount_card));
        CustomToolBar.loadCustomerToolBar(DiscountCardActivity.this,
                getString(R.string.title_discount_card),getDrawable(R.drawable.ic_left_arrow));
    }
}
