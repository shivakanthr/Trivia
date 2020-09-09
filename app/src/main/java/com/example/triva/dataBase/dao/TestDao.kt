package com.example.triva.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item:com.example.triva.dataBase.data.GameData)

    @Query("Select * from gameData")
    suspend fun getAllUserData(): List<com.example.triva.dataBase.data.GameData>

}