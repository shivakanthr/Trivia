package com.example.triva.dataBase

import androidx.room.TypeConverter
import com.example.triva.dataBase.data.QuestionAnswer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class QuestionsConverter {

    @TypeConverter
    fun stringToObject(data: String?): List<QuestionAnswer> {
        if (data == null || data == "null") return emptyList()

        return Gson().fromJson(data, object : TypeToken<List<QuestionAnswer>>() {}.type)
    }

    @TypeConverter
    fun objectToString(list: List<QuestionAnswer>?): String = Gson().toJson(list)

}