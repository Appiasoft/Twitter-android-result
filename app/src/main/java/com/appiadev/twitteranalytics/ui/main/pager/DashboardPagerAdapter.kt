package com.appiadev.twitteranalytics.ui.main.pager

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.appiadev.twitteranalytics.R
import com.appiadev.twitteranalytics.ui.main.PersonsListFragment
import com.appiadev.twitteranalytics.ui.main.fragments.DasboardFragment
import com.appiadev.twitteranalytics.ui.main.fragments.dashboard.DevicesFragment
import com.appiadev.twitteranalytics.ui.main.fragments.dashboard.HashtagsFragment
import com.appiadev.twitteranalytics.ui.main.fragments.dashboard.LocationsFragment

private val TAB_TITLES = arrayOf(
    "Localizacion",
    "Devices",
    "Hashtags"
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class DashboardPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position){
            0 -> fragment = DevicesFragment()
            1 -> fragment = LocationsFragment()
            2 ->  fragment =  HashtagsFragment()
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}