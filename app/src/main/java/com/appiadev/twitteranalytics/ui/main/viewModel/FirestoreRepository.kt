package com.twovehiculo.android.helpers


import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreRepository {

    val TAG = "FIREBASE_REPOSITORY"
    val PERSON_TABLE = "persons"
    val VEHICLE_TABLE = "vehicle"

    var firestoreDB = FirebaseFirestore.getInstance()

    /**
     * A simple [FirebaseFirestore] methods to get TypeVehicles information.
     *
     * 1.getSavedUser
     */

    fun getPersonList(): CollectionReference {
        return firestoreDB.collection(PERSON_TABLE)
    }

    /**
     * A simple [FirebaseFirestore] methods to get Vehicle brands with type information.
     *
     * 1.getSavedUser
     */

    fun getTwettsByName(table_name: String): CollectionReference {
        var collectionReference : CollectionReference = firestoreDB.collection(table_name)
        return collectionReference
    }
}