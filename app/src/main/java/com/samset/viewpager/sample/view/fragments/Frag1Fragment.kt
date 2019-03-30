package com.samset.viewpager.sample.view.fragments


import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samset.viewpager.sample.R

import com.samset.viewpager.sample.observe.MyObserver
import kotlinx.android.synthetic.main.fragment_frag1.*


/**
 * A simple [Fragment] subclass.
 */
class Frag1Fragment : Fragment(), MyObserver {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_frag1, container, false)
    }

    override fun onsetDataFrag1(newValue: String) {
        tvtext.text = newValue
        Log.e("TAG"," frag 1 "+newValue)
    }

    override fun onsetDataFrag2(newValue: String) {

    }

    override fun onsetDataFrag3(newValue: String) {

    }

    override fun onsetDataFrag4(newValue: String) {

    }
}// Required empty public constructor
