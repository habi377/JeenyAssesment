package com.habib.jeenyassesment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MostViewedArticleDao {
    @Query("select * from articles_items")
    fun getArticles(): LiveData<List<MostViewedArticlesItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( articlesItem : List<MostViewedArticlesItem>)
}