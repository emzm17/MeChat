package com.example.mechat

import com.google.firebase.firestore.FieldValue

data class User(
    val name: String,
    val imageUrl: String,
    val thumbImage: String,
    val deviceToken: String,
    val status: String,
    val online: Boolean,
    val uid: String
) {
    /* Empty [Constructor] for Firebase */
    constructor() : this("", "", "", "", "Hey There, I am using meChat", false, "")

    constructor(name: String, imageUrl: String, thumbImage: String, uid: String) :
            this(name, imageUrl, thumbImage, "", uid = uid, status = "Hey There, I am using meChat", online = false)

}