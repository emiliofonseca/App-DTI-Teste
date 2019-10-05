package com.emilio.dtitest.network.di

import com.emilio.dtitest.BuildConfig
import com.emilio.dtitest.network.domain.model.UnsafeOkHttpClient
import com.emilio.dtitest.network.remote.MyApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.DATA_API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return UnsafeOkHttpClient.unsafeOkHttpClient
}

fun provideApi(retrofit: Retrofit) = retrofit.create(MyApi::class.java)