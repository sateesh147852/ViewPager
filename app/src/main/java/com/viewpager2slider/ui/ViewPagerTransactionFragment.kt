package com.viewpager2slider.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.viewpager2slider.adapter.ImageAdapter
import com.viewpager2slider.databinding.FragmentViewPagerTransactionBinding
import kotlin.math.abs

class ViewPagerTransactionFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerTransactionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.apply {
            adapter = ImageAdapter(getImageList())
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3

            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(40))
            compositePageTransformer.addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.20f
            }

            setPageTransformer(compositePageTransformer)
        }

    }

    private fun getImageList(): ArrayList<String> {
        val imageList = ArrayList<String>()
        imageList.add("https://img.freepik.com/premium-photo/handsome-man-positive-male-portrait-masculine_279525-15451.jpg?size=626&ext=jpg&ga=GA1.1.2114095750.1696318813&semt=ais")
        imageList.add("https://img.freepik.com/premium-photo/handsome-man-positive-male-portrait-masculine_279525-15451.jpg?size=626&ext=jpg&ga=GA1.1.2114095750.1696318813&semt=ais")
        imageList.add("https://img.freepik.com/premium-photo/handsome-man-positive-male-portrait-masculine_279525-15451.jpg?size=626&ext=jpg&ga=GA1.1.2114095750.1696318813&semt=ais")
        imageList.add("https://img.freepik.com/premium-photo/handsome-man-positive-male-portrait-masculine_279525-15451.jpg?size=626&ext=jpg&ga=GA1.1.2114095750.1696318813&semt=ais")
        imageList.add("https://img.freepik.com/premium-photo/handsome-man-positive-male-portrait-masculine_279525-15451.jpg?size=626&ext=jpg&ga=GA1.1.2114095750.1696318813&semt=ais")
        imageList.add("https://img.freepik.com/premium-photo/handsome-man-positive-male-portrait-masculine_279525-15451.jpg?size=626&ext=jpg&ga=GA1.1.2114095750.1696318813&semt=ais")
        imageList.add("https://img.freepik.com/premium-photo/handsome-man-positive-male-portrait-masculine_279525-15451.jpg?size=626&ext=jpg&ga=GA1.1.2114095750.1696318813&semt=ais")
        return imageList
    }
}