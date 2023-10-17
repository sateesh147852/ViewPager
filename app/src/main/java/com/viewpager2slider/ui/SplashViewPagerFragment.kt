package com.viewpager2slider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.viewpager2slider.R
import com.viewpager2slider.adapter.SplashAdapter
import com.viewpager2slider.databinding.FragmentSplashViewPagerBinding
import com.viewpager2slider.model.SplashModel
import com.viewpager2slider.navigation.Navigator

class SplashViewPagerFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentSplashViewPagerBinding
    private var currentPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager2.apply {
            adapter = SplashAdapter(getSplashModelForAdapter())
        }
        binding.circleCenter.setViewPager(binding.viewPager2)
        binding.ivForward.setOnClickListener(this)
        binding.ivBackword.setOnClickListener(this)
        binding.tvSkip.setOnClickListener(this)

        binding.viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                currentPosition = position
                if (currentPosition == 0) {
                    binding.ivBackword.visibility = View.GONE
                } else {
                    binding.ivBackword.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun getSplashModelForAdapter(): ArrayList<SplashModel> {
        val splashModel = ArrayList<SplashModel>()
        splashModel.add(
            SplashModel(
                getString(R.string.intro_title_1), getString(R.string.intro_sub_title_1),
                ContextCompat.getColor(requireContext(), R.color.purple_200)
            )
        )
        splashModel.add(
            SplashModel(
                getString(R.string.intro_title_2), getString(R.string.intro_sub_title_2),
                ContextCompat.getColor(requireContext(), R.color.teal_700)
            )
        )
        splashModel.add(
            SplashModel(
                getString(R.string.intro_title_3), getString(R.string.intro_sub_title_3),
                ContextCompat.getColor(requireContext(), R.color.teal_200)
            )
        )
        return splashModel
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.ivForward -> {
                if (currentPosition < 2) {
                    binding.viewPager2.setCurrentItem(++currentPosition, true)
                }
                else{
                    Navigator.replaceFragment(HomeFragment(),false)
                }
            }

            R.id.ivBackword -> {
                if (currentPosition > 0) {
                    binding.viewPager2.setCurrentItem(--currentPosition, true)
                } else {
                    binding.ivBackword.visibility = View.GONE
                }
            }
            R.id.tvSkip -> {
                Navigator.replaceFragment(HomeFragment(),false)
            }
        }
    }
}