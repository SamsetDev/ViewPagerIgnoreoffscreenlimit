package com.samset.viewpager.sample.view

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

import com.samset.viewpager.sample.R
import com.samset.viewpager.sample.adapter.TabpageAdapter
import com.samset.viewpager.sample.observe.MyObservable
import com.samset.viewpager.sample.observe.MyObserver
import com.samset.viewpager.sample.view.fragments.Frag1Fragment
import com.samset.viewpager.sample.view.fragments.Frag2Fragment
import com.samset.viewpager.sample.view.fragments.Frag3Fragment
import com.samset.viewpager.sample.view.fragments.Frag4Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyObservable {


    private lateinit var observable: ArrayList<MyObserver>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observable = ArrayList()
        setupTab()
    }


    private fun setupTab() {
        val pageradapter = TabpageAdapter(supportFragmentManager, getFragments(), getTitles())
        tab.setupWithViewPager(viewpager)
        viewpager.adapter = pageradapter
        viewpager.offscreenPageLimit
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                when (position) {

                    0 -> {
                        notifyObservers1("Fragment 1 data ")
                    }
                    1 -> {
                        notifyObservers2("Fragment 2 data ")
                    }
                    2 -> {
                        notifyObservers3("Fragment 3 data ")
                    }
                    3 -> {
                        notifyObservers4("Fragment 4 data ")

                    }
                }
            }


        })

    }


    override fun addObserver(maddObserver: MyObserver?) {
        maddObserver?.let { observable.add(it) }

    }

    override fun removeObserver(rmObserver: MyObserver?) {
        observable.remove(rmObserver)
    }

    override fun notifyObservers1( data: String) {
        for (observer in observable) {
            observer.onsetDataFrag1(data)
        }
    }

    override fun notifyObservers2( data: String) {
        for (observer in observable) {
            observer.onsetDataFrag2(data)
        }
    }

    override fun notifyObservers3( data: String) {
        for (observer in observable) {
            observer.onsetDataFrag3(data)
        }
    }

    override fun notifyObservers4( data: String) {
        for (observer in observable) {
            observer.onsetDataFrag4(data)
        }
    }


    public fun getTitles(): List<String> {
        val list = ArrayList<String>()
        list.add("Fragment-1")
        list.add("Fragment-2")
        list.add("Fragment-3")
        list.add("Fragment-4")
        return list
    }


    private fun getFragments(): List<Fragment> {
        val list = ArrayList<Fragment>()
        val frag1 = Frag1Fragment()
        observable.add(frag1)
        val frag2 = Frag2Fragment()
        observable.add(frag2)
        val frag3 = Frag3Fragment()
        observable.add(frag3)
        val frag4 = Frag4Fragment()
        observable.add(frag4)
        list.add(frag1)
        list.add(frag2)
        list.add(frag3)
        list.add(frag4)
        return list
    }


}
