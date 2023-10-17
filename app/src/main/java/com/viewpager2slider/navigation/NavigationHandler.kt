package com.viewpager2slider.navigation

import androidx.fragment.app.Fragment

interface NavigationHandler {

    fun addFragment(fragment: Fragment, addToBackStack: Boolean = false)

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = false)

    fun popBackStack()

    fun popBackStackStill(fragment: Fragment)
}