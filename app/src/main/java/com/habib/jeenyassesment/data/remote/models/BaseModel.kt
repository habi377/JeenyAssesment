package com.habib.jeenyassesment.data.remote.models

import com.google.gson.annotations.SerializedName
import com.habib.jeenyassesment.data.remote.models.mostviewed.Results

data class BaseModel(
    @SerializedName("status") val status : String,
    @SerializedName("copyright") val copyright : String,
    @SerializedName("num_results") val num_results : Int,
    @SerializedName("results") val results : List<Results>
)