package com.evicky.core.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignInRemoteData(val id: Long, val name: String, val address: String, val occupation: String): Parcelable