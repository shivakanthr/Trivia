package com.example.triva.repository

import android.app.Application
import com.example.triva.dataBase.TestRoomDb
import com.example.triva.dataBase.data.GameData

class TestRepository(application: Application) {

    private val testDao = TestRoomDb.getInstance(application.applicationContext).getTestDao()

    suspend fun insertUserData(item:GameData) {
        testDao.insert(item)
    }

    suspend fun getUserList(): List<GameData> {
        return testDao.getAllUserData()
    }

}