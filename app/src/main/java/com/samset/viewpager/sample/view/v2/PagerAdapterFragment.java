package com.samset.viewpager.sample.view.v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.samset.viewpager.sample.R;
import com.samset.viewpager.sample.view.v2.Utililitis.Utils;
import com.samset.viewpager.sample.view.v2.adapter.MyPagerAdapter;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * Copyright (C) ViewPagerIgnoreoffscreenlimit - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 30/03/19 at 5:58 PM for ViewPagerIgnoreoffscreenlimit .
 */


public class PagerAdapterFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "PagerAdapterFragment";
    private MyPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<Utils.DummyItem> dummyItems;

    /* Avoid non-default constructors in fragments: use a default constructor plus Fragment.setArguments(Bundle) instead and use Type value = getArguments().getType("key") to retrieve back the values in the bundle in onCreateView()*/
    public PagerAdapterFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sample, container, false);
        rootView.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        Button buttonThumb = rootView.findViewById(R.id.button_thumb);
        Button buttonFull = rootView.findViewById(R.id.button_full);
        buttonThumb.setOnClickListener(this);
        buttonFull.setOnClickListener(this);
        ViewPager viewPager = rootView.findViewById(R.id.viewpager);
        mViewPager = rootView.findViewById(R.id.viewpager);
        dummyItems = new ArrayList<>();
        dummyItems.addAll(Utils.getThumbImageList());
        mPagerAdapter = new MyPagerAdapter(dummyItems, getActivity());
        mViewPager.setAdapter(mPagerAdapter);
        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_thumb:
                dummyItems.clear();
                dummyItems.addAll(Utils.getThumbImageList());
                mPagerAdapter.notifyDataSetChanged();
                break;
            case R.id.button_full:
                dummyItems.clear();
                dummyItems.addAll(Utils.getFullImageList());
                mPagerAdapter.notifyDataSetChanged();
                break;

        }
    }
}
