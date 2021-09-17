package com.habib.jeenyassesment.data.remote.models.mostviewed

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MediaMetadata(
    @SerializedName("url") val url : String,
    @SerializedName("format") val format : String,
    @SerializedName("height") val height : Int,
    @SerializedName("width") val width : Int
) : Serializable