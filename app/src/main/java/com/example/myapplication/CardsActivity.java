package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.cards.DiscountCardActivity;
import com.example.myapplication.cards.EarnPointActivity;
import com.example.myapplication.toolbar.CustomToolBar;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CardsActivity extends AppCompatActivity implements
        View.OnClickListener{

    Toolbar mToolBar;
    TextView mTvTitleBar;
    RelativeLayout mRlEarnPoint;
    RelativeLayout mRlStampCard;
    RelativeLayout mRlDiscountCard;

    Intent mCartIntent = null;
    List<Drawable> mDrawables = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_layout);

//        mToolBar = (Toolbar) findViewById(R.id.toolBar);
//        mToolBar.setTitle("");
//        mToolBar.setNavigationIcon(R.drawable.ic_cancel);
//        setSupportActionBar(mToolBar);

//        mTvTitleBar = (TextView)findViewById(R.id.tvTitleBar);
//        mTvTitleBar.setText(getResources().getString(R.string.title_card));

        CustomToolBar.loadCustomerToolBar(CardsActivity.this,getString(R.string.title_card),
                getDrawable(R.drawable.ic_cancel))
                .setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });

        //
        mRlEarnPoint = (RelativeLayout) findViewById(R.id.rlEarnCard);
        mRlEarnPoint.setOnClickListener(this);
        //
        mRlStampCard = (RelativeLayout)findViewById(R.id.rlStampCard);
        mRlStampCard.setOnClickListener(this);
        //
        mRlDiscountCard = (RelativeLayout)findViewById(R.id.rlDiscountCard);
        mRlDiscountCard.setOnClickListener(this);

        //
        mDrawables = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        try{
            switch (view.getId()){
                case R.id.rlEarnCard:
                    mCartIntent = new Intent(CardsActivity.this, EarnPointActivity.class);
                    startActivity(mCartIntent);
                    break;
                case R.id.rlStampCard:
                    mCartIntent = new Intent(CardsActivity.this, StampCardActivity.class);
                    startActivity(mCartIntent);
                    break;
                case R.id.rlDiscountCard:
                    mCartIntent = new Intent(CardsActivity.this, DiscountCardActivity.class);
                    startActivity(mCartIntent);
                    break;

                default:
                    break;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void makeImageRounded(int[] res){
        for (int imageRes:res){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imageRes);
            RoundedBitmapDrawable rounded = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
            rounded.setCornerRadius(45);
            rounded.setAntiAlias(true);

            mDrawables.add(rounded);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeImageRounded(new int[] {R.drawable.earn_card,R.drawable.food_green,R.drawable.food_red});
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRlEarnPoint.setBackground(mDrawables.get(0));
        mRlStampCard.setBackground(mDrawables.get(1));
        mRlDiscountCard.setBackground(mDrawables.get(2));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDrawables.clear();
    }
}
