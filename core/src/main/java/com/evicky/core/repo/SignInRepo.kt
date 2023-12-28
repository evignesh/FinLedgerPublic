package com.evicky.core.repo

import com.evicky.core.dataSource.DynamoDb
import com.evicky.core.dataSource.Firestore
import com.evicky.core.dataSource.IDataSource
import com.evicky.core.model.local.SignInLocalData

interface ISignInRepo {
    suspend fun writeData(documentPath: String, data: SignInLocalData, logTag: String): Boolean
    suspend fun readData(logTag: String, path: String): Map<String, Any>
}

class SignInRepo(firestore: Firestore, dynamoDb: DynamoDb): ISignInRepo {

    private val isPremiumUser = false // This data may come from some other data source
    private val dataSource: IDataSource = if (isPremiumUser) dynamoDb else firestore

    override suspend fun writeData(documentPath: String, data: SignInLocalData, logTag: String): Boolean = dataSource.writeData(
            documentPath = documentPath, data =  data, logTag = logTag, writeSuccessLogMessage = "Data written successfully", writeFailureLogMessage = "Data write failed")

    override suspend fun readData(logTag: String, path: String): Map<String, Any> = dataSource.readData(logTag, documentPath = path) ?: mapOf()

}