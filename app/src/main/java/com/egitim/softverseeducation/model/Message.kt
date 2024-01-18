package com.egitim.softverseeducation.model

import java.util.Date


data class Message(
    var userName: String,
    var userLastMessage: String,
    var messageTime: String? = null
)