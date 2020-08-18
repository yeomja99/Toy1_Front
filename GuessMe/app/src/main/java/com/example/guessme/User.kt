package com.example.guessme

import java.io.Serializable

class User(
    var username: String? = null,
    var token: String? = null
): Serializable