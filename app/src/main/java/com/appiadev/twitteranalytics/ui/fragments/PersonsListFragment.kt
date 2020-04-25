package com.appiadev.twitteranalytics.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.appiadev.twitteranalytics.R
import com.appiadev.twitteranalytics.ui.main.adapter.PersonsAdapter
import com.twovehiculo.android.helpers.FirestoreViewModel
import kotlinx.android.synthetic.main.fragment_persons_list.*

/**
 * A simple [Fragment] subclass.
 */
class PersonsListFragment : Fragment() {

    private lateinit var viewModel: FirestoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_persons_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirestoreViewModel::class.java)
        recycler_persons.layoutManager = LinearLayoutManager(context)
        viewModel.getPersonList().observeForever { list ->
            recycler_persons.adapter = PersonsAdapter(list,context, PersonsAdapter.OnItemClickListener {
                var intent = Intent(context, TwettsActivity::class.java)
                intent.putExtra("name",it.person)
                startActivity(intent)
            })
        }
    }

}
