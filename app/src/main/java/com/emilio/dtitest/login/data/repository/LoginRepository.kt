package com.emilio.dtitest.login.data.repository

import com.emilio.dtitest.network.remote.MyApi
import com.emilio.dtitest.shared.domain.model.User

class LoginRepository(private val api: MyApi) {

    suspend fun login(user: User) = api.login(user)

    suspend fun register(user: User) = api.register(user)
}