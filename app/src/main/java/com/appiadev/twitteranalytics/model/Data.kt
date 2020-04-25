package com.appiadev.twitteranalytics.ui.main.model

import com.google.firebase.firestore.PropertyName

data class Data(
    @get:PropertyName("name")
    @set:PropertyName("name")
    var name: String = "",
    @get:PropertyName("total")
    @set:PropertyName("total")
    var total: Int = 0
)