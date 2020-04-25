package com.twovehiculo.android.helpers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appiadev.twitteranalytics.ui.main.model.Person
import com.appiadev.twitteranalytics.ui.main.model.Twett
import com.google.firebase.firestore.EventListener

class FirestoreViewModel: ViewModel() {

    val TAG = "FIRESTORE_VIEW_MODEL"
    var firebaseRepository = FirestoreRepository()

    var person : MutableLiveData<List<Person>> = MutableLiveData()
    var twett : MutableLiveData<List<Twett>> = MutableLiveData()

    fun getPersonList(): LiveData<List<Person>>{
        firebaseRepository.getPersonList().addSnapshotListener(EventListener { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                person.value = null
                return@EventListener
            }

            var savedAddressList : MutableList<Person> = mutableListOf()
            for (doc in value!!) {
                var addressItem = doc.toObject(Person::class.java)
                savedAddressList.add(addressItem)
            }
            person.value = savedAddressList
        })

        return person
    }

    fun getTweets(name : String): LiveData<List<Twett>>{
        firebaseRepository.getTwettsByName(name).addSnapshotListener(EventListener { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                twett.value = null
                return@EventListener
            }

            var savedAddressList : MutableList<Twett> = mutableListOf()
            for (doc in value!!) {
                var addressItem = doc.toObject(Twett::class.java)
                savedAddressList.add(addressItem)
            }
            twett.value = savedAddressList
        })

        return twett
    }

}