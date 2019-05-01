package com.samset.viewpager.sample.view.v2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.samset.viewpager.sample.R;
import com.samset.viewpager.sample.view.v2.Utililitis.ImageLoaderUtil;
import com.samset.viewpager.sample.view.v2.Utililitis.Utils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by noor on 02/04/15.
 */
public class SampleFragment extends Fragment {

    Utils.DummyItem dummyItem;
    private String TAG = "PagerFragment";
    private String title;

    public SampleFragment() {
    }

    public static Fragment getInstance(/*String imageUrl, String title*/) {
        Fragment fragment = new SampleFragment();
        //We will not pass the data through setArguments() method using bundle because it will not gets updated by calling notifyDataSetChanged()  method. We will do it through getter and setter.
        //Bundle bundle = new Bundle();
        //bundle.putString(Utils.EXTRA_IMAGE_URL, imageUrl);
        //bundle.putString(Utils.EXTRA_TITLE, title);
        //fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"****PagerFragment onAttach() ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"****PagerFragment onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photo_layout, container, false);
        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        //If we have the requirement of adding, removing or changing the fragment data once it has been instantiated, We will set the data explicitly in the fragment through a getter and setter.
        //Bundle bundle = getArguments();
        //title = bundle.getString(Utils.EXTRA_TITLE);
        //titleTextView.setText(bundle.getString(Utils.EXTRA_TITLE));
        title = dummyItem.getImageTitle();
        titleTextView.setText(title);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        //ImageLoaderUtil.downloadImage(bundle.getString(Utils.EXTRA_IMAGE_URL), imageView);
        ImageLoaderUtil.downloadImage(dummyItem.getImageUrl(), imageView);
        Log.i(TAG,"****PagerFragment onCreateView()#"+title);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG,"****PagerFragment onViewCreated()#"+title);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"****PagerFragment onActivityCreated()#"+title);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(TAG,"****PagerFragment onViewStateRestored()#"+title);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"****PagerFragment onStart()#"+title);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"****PagerFragment onResume()_____________________________________________________#"+title);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"****PagerFragment onPause()#"+title);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"****PagerFragment onStop()#"+title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"****PagerFragment onDestroyView()*************************************#"+title);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"****PagerFragment onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"****PagerFragment onDetach()^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^#"+title);
    }

    public Utils.DummyItem getDummyItem() {

        return dummyItem;
    }



    public void setDummyItem(Utils.DummyItem dummyItem) {
        this.dummyItem = dummyItem;
        Log.i(TAG,"setDummyItem:Title:"+dummyItem.getImageTitle());
    }
}
