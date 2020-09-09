package com.example.triva.dataBase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameData")
data class GameData(
    @PrimaryKey(autoGenerate = true)
    val id:Int= 0,
    var name: String = "",
    var date: String = "",
    var questionAns: MutableList<QuestionAnswer> = mutableListOf()
)

data class QuestionAnswer(
    var question: String = "",
    var answer: List<String> = emptyList()
)