package com.evicky.utility.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface ICoroutineDispatcherProvider {
    fun main(): CoroutineDispatcher = Dispatchers.Main
    fun mainImmediate(): CoroutineDispatcher = Dispatchers.Main.immediate
    fun default(): CoroutineDispatcher = Dispatchers.Default
    fun io(): CoroutineDispatcher = Dispatchers.IO
    fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}

class CoroutineDispatcherProvider : ICoroutineDispatcherProvider

class TestCoroutineDispatcherProvider : ICoroutineDispatcherProvider {
//    override fun main(): CoroutineDispatcher = UnconfinedTestDispatcher()
//    override fun default(): CoroutineDispatcher = UnconfinedTestDispatcher()
//    override fun io(): CoroutineDispatcher = UnconfinedTestDispatcher()
//    override fun unconfined(): CoroutineDispatcher = UnconfinedTestDispatcher()
}