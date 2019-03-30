package com.samset.viewpager.sample.view.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.samset.viewpager.sample.R
import com.samset.viewpager.sample.observe.MyObservable
import com.samset.viewpager.sample.observe.MyObserver
import kotlinx.android.synthetic.main.fragment_frag2.*


/**
 * A simple [Fragment] subclass.
 */
class Frag2Fragment : Fragment(), MyObserver {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false)
    }

    override fun onsetDataFrag1(newValue: String) {
        Log.e("TAG"," frag 2 "+newValue)
    }

    override fun onsetDataFrag2(newValue: String) {
        tvtext2.text = newValue
        Log.e("TAG"," frag 2 "+newValue)
    }

    override fun onsetDataFrag3(newValue: String) {

    }

    override fun onsetDataFrag4(newValue: String) {

    }

}// Required empty public constructor
