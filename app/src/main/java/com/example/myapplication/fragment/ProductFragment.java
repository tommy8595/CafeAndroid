package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.example.myapplication.adapter.ProductAdapter;

public class ProductFragment extends Fragment {

    RecyclerView mRvProduct;
    ProductAdapter mProductAdapter;
    private static final int SPAN_COUNT = 2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.product_recycler_view,container,false);

        //Allow has menu option
        setHasOptionsMenu(true);

        mRvProduct = (RecyclerView)rootView.findViewById(R.id.productRecyclerView);


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),SPAN_COUNT);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
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