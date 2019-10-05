package com.emilio.dtitest.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(
    @SerializedName("sucesso")
    val success: Boolean,
    @SerializedName("mensagemErro")
    val errorMessage: String?
) : Parcelable
