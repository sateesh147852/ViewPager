package com.viewpager2slider.navigation

import androidx.fragment.app.Fragment
import com.viewpager2slider.ui.MainActivity

object Navigator {

    private var navigationHandler: NavigationHandler? = null

    fun registerNavigationHandler(navigationHandler: NavigationHandler) {
        if (navigationHandler is MainActivity) {
            this.navigationHandler = navigationHandler
        }
    }

    fun unRegisterNavigationHandler() {
        navigationHandler = null
    }

    fun addFragment(fragment: Fragment, addToBackStack: Boolean) {
        navigationHandler?.addFragment(fragment, addToBackStack)
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        navigationHandler?.replaceFragment(fragment, addToBackStack)
    }

    fun popBackStack() {
        navigationHandler?.popBackStack()
    }

    fun popBackStackStill(fragment: Fragment) {
        navigationHandler?.popBackStackStill(fragment)
    }

}