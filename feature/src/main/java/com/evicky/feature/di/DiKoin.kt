package com.evicky.feature.di

import com.evicky.feature.login.SignInViewModel
import com.evicky.feature.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SignInViewModel)
    viewModelOf(::RegisterViewModel)
}