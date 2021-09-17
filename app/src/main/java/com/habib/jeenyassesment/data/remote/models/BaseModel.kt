package com.habib.jeenyassesment.data.remote.models

import com.google.gson.annotations.SerializedName
import com.habib.jeenyassesment.data.local.MostViewedArticlesItem
import com.habib.jeenyassesment.data.remote.models.mostviewed.Results

data class BaseModel(
    @SerializedName("status") val status : String,
    @SerializedName("copyright") val copyright : String,
    @SerializedName("num_results") val num_results : Int,
    @SerializedName("results") val results : List<Results>
)

fun BaseModel.asDatabaseModel(): List<MostViewedArticlesItem> {
    return results.map {
        MostViewedArticlesItem(
            articleTitle = it.title,
            imageUrl = if (it.media.isNotEmpty()){it.media[0].mediaMetadata[0].url}else{""},
            imageWidth = if (it.media.isNotEmpty()){it.media[0].mediaMetadata[0].width}else{0},
            imageHeight = if (it.media.isNotEmpty()){it.media[0].mediaMetadata[0].height}else{0},
            byLine = it.byline,
            section = it.section,
            publishedDate = it.published_date,
            articleUrl = it.url
        )
    }
}