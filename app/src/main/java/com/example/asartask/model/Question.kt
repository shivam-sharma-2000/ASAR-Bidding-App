package com.example.asartask.model

import java.io.Serializable

data class Question(
    val questionHeader: String,
    val questionSubtitle: String,
    val questionImage: String,
    val yesValue: Double,
    val noValue: Double,
    var questionAnswer: String?,
    var questionAnswerValue: Double,
    var investedAmount: Double
) : Serializable

