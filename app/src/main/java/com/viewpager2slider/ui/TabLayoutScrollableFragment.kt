package com.viewpager2slider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.viewpager2slider.adapter.ScrollableViewPagerAdapter
import com.viewpager2slider.databinding.FragmentTabLayoutScroableBinding


class TabLayoutScrollableFragment : Fragment() {

    private lateinit var binding: FragmentTabLayoutScroableBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabLayoutScroableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val adapter = ScrollableViewPagerAdapter(childFragmentManager, lifecycle)
            viewPager2.adapter = adapter
            tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                if (position%2 == 0) {
                    tab.text = "HOME"
                } else {
                    tab.text = "PROFILE"
                }
            }.attach()
        }
    }
}