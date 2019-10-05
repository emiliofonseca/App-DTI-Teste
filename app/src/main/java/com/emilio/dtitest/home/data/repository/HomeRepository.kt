package com.emilio.dtitest.home.data.repository

import com.emilio.dtitest.network.remote.MyApi

class HomeRepository(private val api: MyApi) {
    suspend fun getValues() = api.getValues()
}