package com.example.flowersdb.screen.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowersdb.model.database.FlowersDao
import com.example.flowersdb.model.database.entities.Family
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DialogFamilyViewModel@Inject constructor(
    private val repository: FlowersDao
) : ViewModel() { private val exceptionHandler =
    CoroutineExceptionHandler { _, throwable -> errorMessage.postValue(throwable.message) }
    private var job: Job? = null
    private val errorMessage = MutableLiveData<String>()

    fun insertFamily(familyName: String) {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val newFamily = Family(familyName)
            repository.insertNewFamilyData(newFamily.toFamilyDbEntity())
        }
    }
}