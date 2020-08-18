package com.example.guessme.data

import java.io.Serializable

data class Quiz(
    var quizId: Int,
    var content: String,
    var answer: Int
) : Serializable {
    constructor() : this(0, "", 0)
}