package com.emilio.dtitest.network.remote

import com.emilio.dtitest.network.Response
import com.emilio.dtitest.shared.domain.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @POST("/api/account/login")
    suspend fun login(@Body user: User): Response

    @POST("/api/account/register")
    suspend fun register(@Body user: User): Response

    @GET("/api/values")
    suspend fun getValues(): List<String>
}