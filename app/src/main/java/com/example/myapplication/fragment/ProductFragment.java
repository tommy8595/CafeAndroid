package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ImagePageAdapter;
import com.example.myapplication.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ProductFragment extends Fragment {

    RecyclerView mRvProduct;
    ProductAdapter mProductAdapter;
    ViewPager mViewPager;
    ImagePageAdapter mImgPageAdapter = null;

    private Timer mTimer = null;
    private TimerTask mTimerTask = null;
    private static final int SPAN_COUNT = 2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.product_recycler_view,container,false);

        //Allow has menu option
        setHasOptionsMenu(true);

        mRvProduct = (RecyclerView)rootView.findViewById(R.id.productRecyclerView);
        mViewPager = (ViewPager)rootView.findViewById(R.id.viewPager);

        setupImageSlide();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //auto image slide
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            int item = 0;
            @Override
            public void run() {
                if(item == mImgPageAdapter.getCount()){
                    item = -1;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mViewPager.setCurrentItem(item);
                    }
                });
                item++;
            }
        };
        mTimer.scheduleAtFixedRate(mTimerTask,2000,3000);
    }

    private void setupImageSlide(){
        mImgPageAdapter = new ImagePageAdapter(getFragmentManager(),new ArrayList<Integer>(){{
            add(R.drawable.cafe1);
            add(R.drawable.cafe2);
            add(R.drawable.cafe3);
        }});
        mViewPager.setAdapter(mImgPageAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),SPAN_COUNT);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        gridLayoutManager.setReverseLayout(false);
        mRvProduct.setLayoutManager(gridLayoutManager);

        mProductAdapter = new ProductAdapter();
        mRvProduct.setAdapter(mProductAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toolbar,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.actionCart){
            Toast.makeText(getContext(),"This is cart",Toast.LENGTH_LONG)
                    .show();
        }
        return true;
    }
}
