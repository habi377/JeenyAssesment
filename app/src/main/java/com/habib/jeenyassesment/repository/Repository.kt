package com.habib.jeenyassesment.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.habib.jeenyassesment.data.local.MostViewedArticleDao
import com.habib.jeenyassesment.data.local.asDomainModel
import com.habib.jeenyassesment.data.local.models.MostViewedArticleDomainModel
import com.habib.jeenyassesment.data.remote.NYtimesAPI
import com.habib.jeenyassesment.data.remote.models.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(
    private val mostViewedArticleDao: MostViewedArticleDao,
    private val nYtimesAPI: NYtimesAPI
){
    val dataItem: LiveData<List<MostViewedArticleDomainModel>> = Transformations.map(mostViewedArticleDao.getArticles()) {
        it.asDomainModel()
    }
    suspend fun refreshMostViewed(period:Int){
        withContext(Dispatchers.IO) {
            Log.d("","refresh is called")
            val response = nYtimesAPI.getMostViewed(period)
            mostViewedArticleDao.insertAll(response.asDatabaseModel())
        }
    }
}