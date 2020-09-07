package com.example.triva.dataBase.data

data class UserData(
    val name: String,
    val date: String,
    val questionAns: List<QuestionAnswer>
)

data class QuestionAnswer(
    val question: String,
    val answer: List<String>
)