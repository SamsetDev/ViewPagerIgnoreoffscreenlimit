package com.samset.viewpager.sample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.samset.viewpager.sample.R
import com.samset.viewpager.sample.view.v2.MainFragment

class TabHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_host)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.maincontainer, MainFragment()).commit()
        }
    }
}
