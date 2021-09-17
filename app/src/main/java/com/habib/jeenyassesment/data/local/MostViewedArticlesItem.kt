package com.habib.jeenyassesment.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.habib.jeenyassesment.data.local.models.MostViewedArticleDomainModel
import com.habib.jeenyassesment.utils.Constants

@Entity(tableName = Constants.DATABASE_NAME)
data class MostViewedArticlesItem(
    var articleTitle: String,
    var imageUrl: String,
    var imageWidth: Int,
    var imageHeight: Int,
    var byLine: String,
    var section: String,
    var publishedDate: String,
    var articleUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
fun List<MostViewedArticlesItem>.asDomainModel(): List<MostViewedArticleDomainModel> {
    return map {
        MostViewedArticleDomainModel(
            articleTitle = it.articleTitle,
            imageUrl = it.imageUrl,
            imageWidth = it.imageWidth,
            imageHeight = it.imageHeight,
            byLine = it.byLine,
            section = it.section,
            publishedDate = it.publishedDate,
            articleUrl = it.articleUrl
        )
    }
}