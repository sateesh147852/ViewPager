package com.viewpager2slider.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.viewpager2slider.adapter.ViewPagerAdapter
import com.viewpager2slider.databinding.FragmentTabLayoutBinding

class TabLayoutFragment : Fragment() {

    private lateinit var binding: FragmentTabLayoutBinding
    private val tabArray = arrayOf("HOME", "PROFILE")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.apply {
            viewPager2.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = tabArray[position]
            }.attach()
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.i("TABS", "onTabSelected: "+tab?.position + " "+tab?.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.i("TABS", "onTabUnselected: "+tab?.position + " "+tab?.text.toString())
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.i("TABS", "onTabReselected: "+tab?.position + " "+tab?.text.toString())
            }

        })

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                Log.i("VIEWNAGER", "onPageScrolled: "+position)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.i("VIEWNAGER", "onPageSelected: "+position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                Log.i("VIEWNAGER", "onPageScrollStateChanged: "+state)
            }
        })
    }
}