package com.evicky.core.usecase

import com.evicky.core.model.local.SignInLocalData
import com.evicky.core.model.remote.SignInRemoteData
import com.evicky.core.repo.ISignInRepo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class SignInUseCase(private val signInRepo: ISignInRepo) {

    suspend fun writeData(data: SignInLocalData, logTag: String): Boolean {
        return signInRepo.writeData(documentPath = "Users/UserId", data = data, logTag = logTag)
    }

    suspend fun readData(path: String): SignInLocalData {
        val signInRemoteData = Json.decodeFromString<SignInRemoteData>(signInRepo.readData(path = path).toString())
        return SignInLocalData(id = signInRemoteData.id, name = signInRemoteData.name)
    }

}