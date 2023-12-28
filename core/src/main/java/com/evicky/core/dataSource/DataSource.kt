package com.evicky.core.dataSource

import com.evicky.utility.logger.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

interface IDataSource {
    suspend fun writeData(
        documentPath: String,
        data: Any,
        logTag: String,
        writeSuccessLogMessage: String,
        writeFailureLogMessage: String
    ): Boolean

    suspend fun readData(logTag: String, documentPath: String): Map<String, Any>?

    suspend fun deleteData(
        documentPath: String,
        logTag: String,
        writeFailureLogMessage: String
    ): Boolean

}

class Firestore : IDataSource {
//    private val fireStore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override suspend fun writeData(
        documentPath: String,
        data: Any,
        logTag: String,
        writeSuccessLogMessage: String,
        writeFailureLogMessage: String,
    ) = suspendCancellableCoroutine { continuation ->
        try {
//            fireStore.document(documentPath).set(data)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Log.i(logTag, "Data write success to firestore db $writeSuccessLogMessage: $documentPath")
//                        if (continuation.isActive) continuation.resume(true)
//                    } else {
//                        Log.e(logTag,
//                            "Data write failed to firestore db $writeFailureLogMessage: $documentPath. Error Message: ${task.exception?.message}",
//                            task.exception)
//                        if (continuation.isActive) continuation.resume(false)
//                    }
//                }
//            sendSuccessResultIfOfflineForDocumentWrite(fireStore.document(documentPath), continuation)
        } catch (exception: Exception) {
            Log.e(logTag,
                "Exception from execution: Data write failed to firestore db. $writeFailureLogMessage: $documentPath. Error Message: ${exception.message}",
                exception)
            if (continuation.isActive) continuation.resume(false)
        }
    }

    override suspend fun readData(logTag: String, documentPath: String): Map<String, Any>? =
//        fireStore.document(documentPath).get().await().data
        null
    override suspend fun deleteData(
        documentPath: String,
        logTag: String,
        writeFailureLogMessage: String,
    ) = suspendCancellableCoroutine { continuation ->
        try {
//            fireStore.document(documentPath).delete()
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Log.i(logTag, "Delete Success in firestore db: $documentPath")
//                        if (continuation.isActive) continuation.resume(true)
//                    } else {
//                        Log.e(logTag,
//                            "Delete Failure in firestore db: $writeFailureLogMessage: $documentPath. Error Message: ${task.exception?.message}",
//                            task.exception)
//                        if (continuation.isActive) continuation.resume(false)
//                    }
//
//                }
        } catch (exception: Exception) {
            Log.e(logTag,
                "Exception from execution: Delete Failure in firestore db: $writeFailureLogMessage: $documentPath. Error Message: ${exception.message}",
                exception)
            if (continuation.isActive) continuation.resume(false)
        }

    }
}

/**
 * While the device is in offline we won't get success or failure task result for writes to firestore.
 * So getting the meta data to send the result back to the caller if the data is from cache.
 */
//fun sendSuccessResultIfOfflineForDocumentWrite(
//    documentReference: DocumentReference,
//    continuation: CancellableContinuation<Boolean>
//) {
//    documentReference.get().addOnSuccessListener {
//        if (it.metadata.isFromCache && continuation.isActive) continuation.resume(true)
//    }
//}

class DynamoDb : IDataSource {
    override suspend fun writeData(
        documentPath: String,
        data: Any,
        logTag: String,
        writeSuccessLogMessage: String,
        writeFailureLogMessage: String,
    ): Boolean {
        Log.i(logTag, "Data write success to dynamo db $writeSuccessLogMessage: $documentPath")
        return true
    }

    override suspend fun readData(logTag: String, documentPath: String): Map<String, Any>? {
        Log.i(logTag, "Data read success from dynamo db $documentPath")
        return null
    }

    override suspend fun deleteData(
        documentPath: String,
        logTag: String,
        writeFailureLogMessage: String,
    ): Boolean {
        Log.i(logTag, "Data delete success in dynamo db $documentPath")
        return true
    }
}