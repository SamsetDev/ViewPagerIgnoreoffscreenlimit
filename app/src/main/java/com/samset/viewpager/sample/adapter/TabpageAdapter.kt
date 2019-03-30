package com.samset.viewpager.sample.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Copyright (C) ViewpaggerIgnorePagelimit - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 *
 *
 * Created by samset on 30/03/19 at 1:47 PM for ViewpaggerIgnorePagelimit .
 */


class TabpageAdapter(fm: FragmentManager?, fragments: List<Fragment>, name: List<String>) : FragmentPagerAdapter(fm) {
    private var title: List<String>
    private lateinit var fragmentlist: List<Fragment>
    private var bundle: Bundle


    init {

        this.title = name
        this.fragmentlist = fragments
        this.bundle = Bundle()
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return title.get(position)

    }


    override fun getItem(position: Int): Fragment {
        return fragmentlist.get(position)

    }

    override fun getCount(): Int {
        return title.size
    }
}