package com.appiadev.twitteranalytics.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.appiadev.twitteranalytics.R
import com.appiadev.twitteranalytics.ui.main.adapter.PersonsAdapter
import com.twovehiculo.android.helpers.FirestoreViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A placeholder fragment containing a simple view.
 */
class DasboardFragment : Fragment() {


    private lateinit var viewModel: FirestoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FirestoreViewModel::class.java)
        recycler_persons.layoutManager = LinearLayoutManager(context)
        viewModel.getPersonList().observeForever {
            recycler_persons.adapter = PersonsAdapter(it,context, PersonsAdapter.OnItemClickListener {

            })
        }
    }

}