package com.viewpager2slider.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.viewpager2slider.R
import com.viewpager2slider.databinding.ActivityMainBinding
import com.viewpager2slider.navigation.NavigationHandler
import com.viewpager2slider.navigation.Navigator

class MainActivity : AppCompatActivity(), NavigationHandler {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentManager = supportFragmentManager
        Navigator.registerNavigationHandler(this)

        Handler(Looper.getMainLooper()).postDelayed({
            //Navigator.replaceFragment(SplashViewPagerFragment(),false)
            //Navigator.replaceFragment(ViewPagerTransactionFragment(),false)
            //Navigator.replaceFragment(TabLayoutFragment(),false)
            //Navigator.replaceFragment(CustomViewPagerFragment(),false)
            Navigator.replaceFragment(TabLayoutScrollableFragment(),false)
        },2000)
    }

    override fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        if (addToBackStack){
            fragmentManager.beginTransaction()
                .add(R.id.fcContainer,fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
        else{
            fragmentManager.beginTransaction()
                .add(R.id.fcContainer,fragment)
                .commitAllowingStateLoss()
        }
    }

    override fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        if (addToBackStack){
            fragmentManager.beginTransaction()
                .replace(R.id.fcContainer,fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
        else{
            fragmentManager.beginTransaction()
                .replace(R.id.fcContainer,fragment)
                .commitAllowingStateLoss()
        }
    }

    override fun popBackStack() {
        fragmentManager.popBackStack()
    }

    override fun popBackStackStill(fragment: Fragment) {

    }
}