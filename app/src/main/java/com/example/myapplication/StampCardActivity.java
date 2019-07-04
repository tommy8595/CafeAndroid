package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.myapplication.toolbar.CustomToolBar;

public class StampCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stamp_card);

        CustomToolBar.loadCustomerToolBar(StampCardActivity.this,getString(R.string.title_stamp_card),getDrawable(R.drawable.ic_left_arrow));
    }
}
