package com.example.feelings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FeelingViewModel (application: Application) : AndroidViewModel(application){

    private val repository : FeelingRepository
    //place where u save data from database
    val allFeelings: LiveData<List<Feeling>>

    init{
        //Get a reference through the DAO
        val feelingDao = FeelingDatabase
            .getDatabase(application)
            .feelingDao()

        // now repository has all DAO data
        repository = FeelingRepository(feelingDao)
        allFeelings = repository.allFeelings

    }

    //ViewModel to use coroutine to perform long precess
    fun insert(feeling: Feeling) = viewModelScope.launch{

         repository.insert(feeling)
    }

}