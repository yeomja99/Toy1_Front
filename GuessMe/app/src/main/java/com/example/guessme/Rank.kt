package com.example.guessme

import java.io.Serializable

data class Rank (
    var number : Int,
    val user : String,
    var score : Int
) : Serializable