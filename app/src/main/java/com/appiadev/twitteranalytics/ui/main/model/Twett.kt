package com.appiadev.twitteranalytics.ui.main.model

import com.google.firebase.firestore.PropertyName

data class Twett(
    @get:PropertyName("created_at")
    @set:PropertyName("created_at")
    var createdAt: String = "",
    @get:PropertyName("text")
    @set:PropertyName("text")
    var text: String = ""
)