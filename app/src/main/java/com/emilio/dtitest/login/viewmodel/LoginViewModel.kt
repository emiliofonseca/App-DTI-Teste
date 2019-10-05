package com.emilio.dtitest.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emilio.dtitest.login.data.repository.LoginRepository
import com.emilio.dtitest.shared.domain.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)
    val showLoading = MutableLiveData<Boolean>()
    val logged = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun login(username: String, password: String) {
        scope.launch {
            showLoading.postValue(true)
            val response = loginRepository.login(User(username, password))
            logged.postValue(response.success)
            error.postValue(response.errorMessage)
            showLoading.postValue(false)
        }
    }

    fun register(username: String, password: String) {
        scope.launch {
            showLoading.postValue(true)
            val response = loginRepository.register(User(username, password))
            logged.postValue(response.success)
            error.postValue(response.errorMessage)
            showLoading.postValue(false)
        }
    }
}