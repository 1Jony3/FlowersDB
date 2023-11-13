package com.example.flowersdb.screen.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowersdb.model.database.FlowersDao
import com.example.flowersdb.model.database.FlowersInfoTuple
import com.example.flowersdb.model.database.entities.FamilyDbEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFlowerViewModel @Inject constructor(
    private val repository: FlowersDao
) : ViewModel() {

    private val _allFamily = MutableLiveData<List<FamilyDbEntity>>()
    val allFamily: LiveData<List<FamilyDbEntity>> = _allFamily

    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> errorMessage.postValue(throwable.message) }
    private var job: Job? = null
    private val errorMessage = MutableLiveData<String>()

    fun insertFlower() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            //val newFlower = Flower()
            //repository.insertNewFlowersData(newFlower.toFlowerDbEntity())
        }
    }
    fun getFamily(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            _allFamily.value = repository.getAllFamilyData()
        }
    }

}