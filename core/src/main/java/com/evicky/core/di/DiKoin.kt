package com.evicky.core.di

import com.evicky.core.usecase.SignInUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::SignInUseCase)
}
