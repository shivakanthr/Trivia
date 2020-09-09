package com.example.triva.dataBase

import android.content.Context
import androidx.room.*
import com.example.triva.dataBase.dao.TestDao


@Database(entities = [com.example.triva.dataBase.data.GameData::class], version = 1)
@TypeConverters(QuestionsConverter::class)
abstract class TestRoomDb : RoomDatabase() {

    abstract fun getTestDao(): TestDao

    companion object {

        @Volatile
        private var instance: TestRoomDb? = null

        fun getInstance(context: Context): TestRoomDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): TestRoomDb {
            return Room.databaseBuilder(context, TestRoomDb::class.java, "app.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}