package com.emilio.dtitest.home.di

import com.emilio.dtitest.home.data.repository.HomeRepository
import com.emilio.dtitest.home.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory { HomeRepository(get()) }
    viewModel { HomeViewModel(get()) }
}