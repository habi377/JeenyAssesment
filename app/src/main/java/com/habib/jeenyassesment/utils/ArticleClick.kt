package com.habib.jeenyassesment.utils

import com.habib.jeenyassesment.data.local.models.MostViewedArticleDomainModel

class ArticleClick(val block: (MostViewedArticleDomainModel) -> Unit) {
    /**
     * Called when a article is clicked
     *
     * @param article the article that was clicked
     */
    fun onClick(article: MostViewedArticleDomainModel) = block(article)
}