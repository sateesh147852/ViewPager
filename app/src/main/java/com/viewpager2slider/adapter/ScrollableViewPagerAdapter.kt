package com.viewpager2slider.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.viewpager2slider.ui.HomeFragment
import com.viewpager2slider.ui.ProfileFragment

class ScrollableViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {

    private val maxItems = 10

    override fun getItemCount(): Int = maxItems

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> ProfileFragment()
            2 -> HomeFragment()
            3 -> ProfileFragment()
            4 -> HomeFragment()
            5 -> ProfileFragment()
            6 -> HomeFragment()
            7 -> ProfileFragment()
            8 -> HomeFragment()
            9 -> ProfileFragment()
            else -> HomeFragment()
        }
    }
}