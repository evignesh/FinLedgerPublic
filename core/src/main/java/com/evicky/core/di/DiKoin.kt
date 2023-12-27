package com.evicky.core.di

import com.evicky.core.dataSource.FireStore
import com.evicky.core.dataSource.IFireStore
import com.evicky.core.repo.ISignInRepo
import com.evicky.core.repo.SignInRepo
import com.evicky.core.usecase.SignInUseCase
import com.evicky.utility.utils.CoroutineDispatcherProvider
import com.evicky.utility.utils.ICoroutineDispatcherProvider
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::SignInUseCase)
}

val repoModule = module {
    factoryOf(::SignInRepo) { bind<ISignInRepo>() }
}

val dataSourceModule = module {
    singleOf(::FireStore) { bind<IFireStore>()}
}

val coroutineDispatcherProviderModule = module {
    singleOf(::CoroutineDispatcherProvider) { bind<ICoroutineDispatcherProvider>()}
}