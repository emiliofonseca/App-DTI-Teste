package com.emilio.dtitest.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emilio.dtitest.home.data.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)
    val showLoading = MutableLiveData<Boolean>()
    val value = MutableLiveData<String>()

    fun getValues() {
        scope.launch {
            showLoading.postValue(true)
            val response = homeRepository.getValues()
            showLoading.postValue(false)
            value.postValue(response.first())
        }
    }
}