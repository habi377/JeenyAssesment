package com.habib.jeenyassesment.data.local.models

import java.io.Serializable

data class MostViewedArticleDomainModel(
    var articleTitle: String,
    var imageUrl: String,
    var imageWidth: Int,
    var imageHeight: Int,
    var byLine: String,
    var section: String,
    var publishedDate: String,
    var articleUrl: String,
) : Serializable