package com.mustafafidan.youtubeclonemvppattern

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.mustafafidan.youtubeclonemvppattern.base.BaseViewPagerAdapter
import com.mustafafidan.youtubeclonemvppattern.databinding.ActivityMainBinding
import com.mustafafidan.youtubeclonemvppattern.ui.home.HomeFragment
import com.mustafafidan.youtubeclonemvppattern.utils.disableShiftMode
import com.mustafafidan.youtubeclonemvppattern.utils.startNewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.bottomNavigation.disableShiftMode()

        setupViewPager(viewpager)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(object: BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.menu_home -> viewpager.setCurrentItem(0,false)


                }
                return true
            }
        })
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = BaseViewPagerAdapter(supportFragmentManager)
        val profileFragment = HomeFragment()

        adapter.addFrag(profileFragment, "") // 0

        viewPager.adapter = adapter
    }
}
