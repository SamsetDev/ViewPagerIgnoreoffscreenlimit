package com.samset.viewpager.sample.view.v2;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.samset.viewpager.sample.R;
import com.samset.viewpager.sample.view.v2.Utililitis.Utils;
import com.samset.viewpager.sample.view.v2.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


/**
 * Created by noor on 10/04/15.
 */
public class FragmentPagerAdapterFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "FragmentPagerAdapterFra";
    private MyFragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<Utils.DummyItem> mDummyItems;

    /* Avoid non-default constructors in fragments: use a default constructor plus Fragment.setArguments(Bundle) instead and use Type value = getArguments().getType("key") to retrieve back the values in the bundle in onCreateView()*/
    public FragmentPagerAdapterFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sample, container, false);
        rootView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        Button buttonThumb = (Button) rootView.findViewById(R.id.button_thumb);
        Button buttonFull = (Button) rootView.findViewById(R.id.button_full);
        buttonThumb.setOnClickListener(this);
        buttonFull.setOnClickListener(this);
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        mDummyItems =new ArrayList<>();
        mDummyItems.addAll(Utils.getThumbImageList());
        mPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mDummyItems);
        mViewPager.setAdapter(mPagerAdapter);
        return rootView;
    }


//    private void currentFragment(){
//        getChildFragmentManager().findFragmentByTag("android:switcher:" + viewPager.getId() + ":" + viewPager.getCurrentItem());
//    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_thumb:
                mDummyItems.clear();
                //Utils.DummyItem dummyItem = mDummyItems.get(5);
                //mDummyItems.remove(4);
                //mDummyItems.add(dummyItem);
                mDummyItems.addAll(Utils.getThumbImageList());
                mPagerAdapter.notifyDataSetChanged();
                break;
            case R.id.button_full:
                mDummyItems.clear();
                //Utils.DummyItem dummyItem1 = mDummyItems.get(8);
                //mDummyItems.add(4,dummyItem1);
                mDummyItems.addAll(Utils.getFullImageList());
                mPagerAdapter.notifyDataSetChanged();
                break;

        }
    }
}
