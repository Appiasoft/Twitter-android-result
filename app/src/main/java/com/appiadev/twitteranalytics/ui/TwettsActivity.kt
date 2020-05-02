package com.appiadev.twitteranalytics.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.appiadev.twitteranalytics.R
import com.appiadev.twitteranalytics.adapter.TwettsAdapter
import com.twovehiculo.android.helpers.FirestoreViewModel
import kotlinx.android.synthetic.main.activity_twetts.*

class TwettsActivity : AppCompatActivity() {

    private lateinit var viewModel: FirestoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twetts)

        viewModel = ViewModelProviders.of(this).get(FirestoreViewModel::class.java)

        recycler_tweet.layoutManager = LinearLayoutManager(this)
        viewModel.getTweets(intent.extras!!.getString("name")!!).observeForever {
            recycler_tweet.adapter = TwettsAdapter(it,this)
        }
    }
}
