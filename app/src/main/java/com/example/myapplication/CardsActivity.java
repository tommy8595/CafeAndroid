package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.cards.EarnPointActivity;

public class CardsActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar mToolBar;
    TextView mTvTitleBar;
    ImageView mImgEarnPoint;

    Intent mCartIntent = null;

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

        //
        mImgEarnPoint = (ImageView)findViewById(R.id.imgEarnPoint);
        mImgEarnPoint.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgEarnPoint:
                mCartIntent = new Intent(CardsActivity.this, EarnPointActivity.class);
                startActivity(mCartIntent);
                break;
        }
    }
}
