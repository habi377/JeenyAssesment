package com.habib.jeenyassesment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MostViewedArticlesItem::class],
    version = 1
)
abstract class MostViewedArticlesDatabase : RoomDatabase() {
    abstract fun MostViewedArticleDao() : MostViewedArticleDao
}