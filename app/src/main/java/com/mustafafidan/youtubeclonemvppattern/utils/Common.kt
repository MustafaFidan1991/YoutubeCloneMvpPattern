package com.mustafafidan.youtubeclonemvppattern.utils

import android.annotation.SuppressLint
import android.content.Intent
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.mustafafidan.youtubeclonemvppattern.base.BaseFragment
import com.mustafafidan.youtubeclonemvppattern.base.BaseViewPagerAdapter
import java.io.*
import java.util.*

/*
* BottomNavigationView
* */
@SuppressLint("RestrictedApi")
fun BottomNavigationView.disableShiftMode(){
    val menuView = this.getChildAt(0) as BottomNavigationMenuView
    try {
        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
        shiftingMode.isAccessible = true
        shiftingMode.setBoolean(menuView, false)
        shiftingMode.isAccessible = false
        for (i in 0..menuView.childCount - 1) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView

            item.setShiftingMode(false)
            // set once again checked value, so view will be updated

            item.setChecked(item.itemData.isChecked)
        }
    } catch (e: NoSuchFieldException) {
        Log.e("BNVHelper", "Unable to get shift mode field", e)
    } catch (e: IllegalAccessException) {
        Log.e("BNVHelper", "Unable to change value of shift mode", e)
    }
}
/*
* */



/*
* Activity
* */
fun <T>AppCompatActivity.startNewActivity(type:Class<T>,passItems :HashMap<String,Serializable>? = null){
    val intent = Intent(this,type)

    if (passItems != null) {
        for ((key, value) in passItems) {
            intent.putExtra(key, value)
        }
    }


    this.startActivity(intent)
}
//



/*viewpager*/

fun ViewPager.setupViewPager(fragmentManager: FragmentManager, fragments: Map<String, BaseFragment<*>>) {
    this.offscreenPageLimit = fragments.size - 1
    val adapter = BaseViewPagerAdapter(fragmentManager)
    for ((key, value) in fragments) {
        adapter.addFrag(value, key)
    }
    this.adapter = adapter
}


/**/






