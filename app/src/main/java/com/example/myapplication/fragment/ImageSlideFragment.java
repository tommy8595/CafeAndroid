package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.List;

public class ImageSlideFragment extends Fragment {

    private ImageView mImgSlide = null;
    int mPos;

    private List<Integer> mImgList = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_slide_layout,container,false);
        mImgSlide = (ImageView) rootView.findViewById(R.id.imgSlide);
        mImgSlide.setImageResource(mImgList.get(mPos));
        return rootView;
    }

    public void setImagePosition(int pos){
        mPos = pos;
    }
    public void setImageList(List<Integer> imageList){
        this.mImgList = imageList;
    }
}
