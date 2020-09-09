package com.example.triva.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.triva.dataBase.data.GameData

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item:GameData)

    @Query("Select * from gameData")
    suspend fun getAllUserData(): List<GameData>

}