package com.viewpager2slider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.viewpager2slider.databinding.FragmentCustomViewPagerBinding

class CustomViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentCustomViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            tabLayout.addTab(tabLayout.newTab(),0)
            tabLayout.addTab(tabLayout.newTab(),1)

            tabLayout.getTabAt(0)?.text = "HOME"
            tabLayout.getTabAt(1)?.text = "PROFILE"

           tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.let { tabView ->
                        when(tabView.position){
                            0 -> {
                                ivOne.visibility = View.VISIBLE
                                ivTwo.visibility = View.GONE
                            }
                            1 -> {
                                ivOne.visibility = View.GONE
                                ivTwo.visibility = View.VISIBLE
                            }
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })
        }
    }
}