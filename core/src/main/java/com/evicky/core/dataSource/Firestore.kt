package com.evicky.core.dataSource

import com.evicky.utility.logger.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

interface IFireStore {
    suspend fun writeToFireStoreDocument(
        documentPath: String,
        data: Any,
        logTag: String,
        writeSuccessLogMessage: String,
        writeFailureLogMessage: String
    ): Boolean

    suspend fun readFromFireStoreDocument(documentPath: String): Map<String, Any>?

    suspend fun deleteFireStoreDocument(
        documentPath: String,
        logTag: String,
        writeFailureLogMessage: String
    ): Boolean

}

class FireStore : IFireStore {
//    private val fireStore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override suspend fun writeToFireStoreDocument(
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
//                        Log.i(logTag, "$writeSuccessLogMessage: $documentPath")
//                        if (continuation.isActive) continuation.resume(true)
//                    } else {
//                        Log.e(logTag,
//                            "$writeFailureLogMessage: $documentPath. Error Message: ${task.exception?.message}",
//                            task.exception)
//                        if (continuation.isActive) continuation.resume(false)
//                    }
//                }
//            sendSuccessResultIfOfflineForDocumentWrite(fireStore.document(documentPath), continuation)
        } catch (exception: Exception) {
            Log.e(logTag,
                "Exception from execution: $writeFailureLogMessage: $documentPath. Error Message: ${exception.message}",
                exception)
            if (continuation.isActive) continuation.resume(false)
        }
    }

    override suspend fun readFromFireStoreDocument(documentPath: String): Map<String, Any>? =
//        fireStore.document(documentPath).get().await().data
        null
    override suspend fun deleteFireStoreDocument(
        documentPath: String,
        logTag: String,
        writeFailureLogMessage: String,
    ) = suspendCancellableCoroutine { continuation ->
        try {
//            fireStore.document(documentPath).delete()
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Log.i(logTag, "Delete Success : $documentPath")
//                        if (continuation.isActive) continuation.resume(true)
//                    } else {
//                        Log.e(logTag,
//                            "$writeFailureLogMessage: $documentPath. Error Message: ${task.exception?.message}",
//                            task.exception)
//                        if (continuation.isActive) continuation.resume(false)
//                    }
//
//                }
        } catch (exception: Exception) {
            Log.e(logTag,
                "Exception from execution: $writeFailureLogMessage: $documentPath. Error Message: ${exception.message}",
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