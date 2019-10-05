package com.emilio.dtitest

import com.emilio.dtitest.home.di.homeModule
import com.emilio.dtitest.login.di.loginModule
import com.emilio.dtitest.network.di.networkModule
import org.koin.dsl.module

val applicationModule = module {
}

val koinModules = listOf(
    applicationModule,
    networkModule,
    loginModule,
    homeModule
)