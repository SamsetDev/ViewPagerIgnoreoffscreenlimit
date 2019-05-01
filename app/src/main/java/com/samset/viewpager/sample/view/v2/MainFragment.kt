package com.samset.viewpager.sample.view.v2


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TabHost
import android.widget.TextView
import androidx.fragment.app.FragmentTabHost

import com.samset.viewpager.sample.R
import com.samset.viewpager.sample.view.v2.Utililitis.Utils
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tabhost.setup(activity, childFragmentManager, android.R.id.tabcontent)

        var bundle = Bundle()
        bundle.putString(Utils.EXTRA_TITLE, Utils.TAB_PAGER_ADAPTER)
        //The third parameter is a Bundle object, that will be received inside the fragment.
        tabhost.addTab(tabhost.newTabSpec(Utils.TAB_PAGER_ADAPTER).setIndicator(Utils.TAB_PAGER_ADAPTER), PagerAdapterFragment::class.java, bundle)

        bundle = Bundle()
        bundle.putString(Utils.EXTRA_TITLE, Utils.TAB_FRAGMENT_PAGER_ADAPTER)
        tabhost.addTab(tabhost.newTabSpec(Utils.TAB_FRAGMENT_PAGER_ADAPTER).setIndicator(Utils.TAB_FRAGMENT_PAGER_ADAPTER), FragmentPagerAdapterFragment::class.java, bundle)

        bundle = Bundle()
        bundle.putString(Utils.EXTRA_TITLE, Utils.TAB_FRAGMENT_STATE_PAGER_ADAPTER)
        tabhost.addTab(tabhost.newTabSpec(Utils.TAB_FRAGMENT_STATE_PAGER_ADAPTER).setIndicator(Utils.TAB_FRAGMENT_STATE_PAGER_ADAPTER), FragmentStatePagerAdapterFragment::class.java, bundle)

        tabhost.setOnTabChangedListener(object : TabHost.OnTabChangeListener{
            override fun onTabChanged(tabId: String) {
                Log.i("TAG", "onTabChanged*** tabId:$tabId")
                when (tabId) {
                    Utils.TAB_PAGER_ADAPTER -> {
                    }
                    Utils.TAB_FRAGMENT_PAGER_ADAPTER -> {
                    }
                    Utils.TAB_FRAGMENT_STATE_PAGER_ADAPTER -> {
                    }
                }
            }

        })

        //By Default the title TextView of Tab shows all caps characters, we are making it setAllCaps(false).
        var tv = tabhost.getTabWidget().getChildAt(0).findViewById(android.R.id.title) as TextView
        tv.isAllCaps = false
        tv = tabhost.getTabWidget().getChildAt(1).findViewById(android.R.id.title)
        tv.isAllCaps = false
        tv = tabhost.getTabWidget().getChildAt(2).findViewById(android.R.id.title)
        tv.isAllCaps = false
    }

    override fun onDestroy() {
        super.onDestroy()

    }



}
