package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class CardsActivity extends AppCompatActivity {

    Toolbar mToolBar;
    TextView mTvTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_layout);

        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mToolBar.setTitle("");
        mToolBar.setNavigationIcon(R.drawable.ic_cancel);
        setSupportActionBar(mToolBar);

        mTvTitleBar = (TextView)findViewById(R.id.tvTitleBar);
        mTvTitleBar.setText(getResources().getString(R.string.title_card));
    }
}
