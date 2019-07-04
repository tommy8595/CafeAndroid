package com.example.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.fragment.ProductFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener {


    Toolbar mToolBar;
    TextView mTvTitleBar;
    public BottomBar mBottomBar;
    ProductFragment mProductFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProductFragment = new ProductFragment();

        mToolBar = (Toolbar)findViewById(R.id.toolBar);
        mTvTitleBar = (TextView)findViewById(R.id.tvTitleBar);

        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);

        //
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
        mBottomBar.setDefaultTab(R.id.tabProduct);
        mBottomBar.setOnTabSelectListener(this);
    }

    @Override
    public void onTabSelected(int tabId) {
        switch (tabId){
            case R.id.tabCard:
                Intent cardsIntent = new Intent(MainActivity.this,CardsActivity.class);
                startActivity(cardsIntent);
                break;

            case R.id.tabProduct:
                mTvTitleBar.setText(getResources().getString(R.string.title_product));
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.fragment,mProductFragment)
                        .addToBackStack("")
                        .commit();
                break;
            case R.id.tabPromotion:
                Intent test =new Intent(MainActivity.this,Login_Activity.class);
                startActivity(test);
            default:
                break;
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        mBottomBar.setDefaultTab(R.id.tabProduct);
        Log.d("TAG","Restart");
    }
}
