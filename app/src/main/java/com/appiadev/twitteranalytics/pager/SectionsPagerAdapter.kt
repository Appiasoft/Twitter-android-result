package com.appiadev.twitteranalytics.ui.main.pager

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.appiadev.twitteranalytics.R
import com.appiadev.twitteranalytics.ui.main.PersonsListFragment
import com.appiadev.twitteranalytics.ui.main.fragments.DasboardFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when(position){
            1 -> DasboardFragment()
            else -> PersonsListFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}