package com.evicky.financeledger.application

import android.app.Application
import com.evicky.core.di.useCaseModule
import com.evicky.feature.di.viewModelModule
import org.koin.core.context.startKoin

class FinanceLedgerApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                viewModelModule, useCaseModule
            )
        }
    }

}