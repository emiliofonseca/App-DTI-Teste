package com.emilio.dtitest.login.di

import com.emilio.dtitest.login.data.repository.LoginRepository
import com.emilio.dtitest.login.viewmodel.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    
    factory { LoginRepository(get()) }
    viewModel { LoginViewModel(get()) }
}