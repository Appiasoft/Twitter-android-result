package com.appiadev.twitteranalytics.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.AppBarConfiguration
import com.appiadev.twitteranalytics.R
import com.google.android.material.bottomnavigation.BottomNavigationView


/**
 * A placeholder fragment containing a simple view.
 */
class DasboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navView: BottomNavigationView = view.findViewById(R.id.nav_view)

        val navController = findNavController(requireActivity(),R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_location, R.id.navigation_devices, R.id.navigation_hashtags
            )
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}