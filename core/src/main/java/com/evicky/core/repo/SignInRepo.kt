package com.evicky.core.repo

import com.evicky.core.dataSource.IFireStore
import com.evicky.core.model.local.SignInLocalData

interface ISignInRepo {
    suspend fun writeData(documentPath: String, data: SignInLocalData, logTag: String): Boolean
    suspend fun readData(path: String): Map<String, Any>
}

class SignInRepo(private val firestore: IFireStore): ISignInRepo {
    override suspend fun writeData(documentPath: String, data: SignInLocalData, logTag: String): Boolean = firestore.writeToFireStoreDocument(
        documentPath = documentPath, data =  data, logTag = logTag, writeSuccessLogMessage = "Data written successfully", writeFailureLogMessage = "Data write failed")
    override suspend fun readData(path: String): Map<String, Any> = firestore.readFromFireStoreDocument(documentPath = path) ?: mapOf()

}