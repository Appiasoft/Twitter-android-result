package com.appiadev.twitteranalytics.ui.main.model

import com.google.firebase.firestore.PropertyName

data class Person(
    @get:PropertyName("person")
    @set:PropertyName("person")
    var person: String = ""
)