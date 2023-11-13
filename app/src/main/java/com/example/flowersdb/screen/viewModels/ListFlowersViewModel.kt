package com.example.flowersdb.screen.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowersdb.model.database.FlowersDao
import com.example.flowersdb.model.database.FlowersInfoTuple
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListFlowersViewModel @Inject constructor(
    private val repository: FlowersDao
    ) : ViewModel() {

    private val _allFlower = MutableLiveData<List<FlowersInfoTuple>>()
    val allFlower: LiveData<List<FlowersInfoTuple>> = _allFlower

    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> errorMessage.postValue(throwable.message) }
    private var job: Job? = null
    private val errorMessage = MutableLiveData<String>()


    init {
        getAllStatistic()
    }

    private fun getAllStatistic() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            _allFlower.value = repository.getAllFlowerData()
        }
    }
}