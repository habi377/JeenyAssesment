package com.habib.jeenyassesment.data.remote.models.mostviewed

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Media(
    @SerializedName("type") val type : String,
    @SerializedName("subtype") val subtype : String,
    @SerializedName("caption") val caption : String,
    @SerializedName("copyright") val copyright : String,
    @SerializedName("approved_for_syndication") val approvedForSyndication : Int,
    @SerializedName("media-metadata") val mediaMetadata : List<MediaMetadata>) : Serializable

