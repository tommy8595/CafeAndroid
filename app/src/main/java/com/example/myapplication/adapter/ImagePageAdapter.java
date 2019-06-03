package com.example.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myapplication.fragment.ImageSlideFragment;
import com.example.myapplication.adapter.ImagePageAdapter;

import java.util.List;

public class ImagePageAdapter extends FragmentPagerAdapter {

    private List<Integer> mImgList;

    public ImagePageAdapter(FragmentManager fm, List<Integer> imgList) {
        super(fm);
        this.mImgList = imgList;
    }

    @Override
    public Fragment getItem(int position) {
        ImageSlideFragment mImgFragment = new ImageSlideFragment();
        mImgFragment.setImageList(mImgList);
        mImgFragment.setImagePosition(position);
        return mImgFragment;
    }

    @Override
    public int getCount() {
        return mImgList.size();
    }
}
