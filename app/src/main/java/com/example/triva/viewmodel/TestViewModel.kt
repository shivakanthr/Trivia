package com.example.triva.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.triva.dataBase.data.GameData
import com.example.triva.repository.TestRepository
import kotlinx.coroutines.launch

class TestViewModel(application: Application) : AndroidViewModel(application) {

    var userData = GameData()

    private val testRepository: TestRepository = TestRepository(application)

    suspend fun insertData(item: GameData) {
        viewModelScope.launch {
            testRepository.insertUserData(item)
        }
    }

    suspend fun getUserList(): LiveData<List<GameData>> {
        val result = MutableLiveData<List<GameData>>()
        viewModelScope.launch {
           result.postValue(testRepository.getUserList())
        }
        return result
    }
}