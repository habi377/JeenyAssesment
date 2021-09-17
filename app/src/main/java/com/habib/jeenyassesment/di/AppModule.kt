package com.habib.jeenyassesment.di

import android.content.Context
import androidx.room.Room
import com.habib.jeenyassesment.data.local.MostViewedArticlesDatabase
import com.habib.jeenyassesment.data.remote.NYtimesAPI
import com.habib.jeenyassesment.utils.Constants.BASE_URL
import com.habib.jeenyassesment.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMostViewedArticlesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, MostViewedArticlesDatabase::class.java, DATABASE_NAME).build()


    @Singleton
    @Provides
    fun provideMostViewedArticleDao(
        database: MostViewedArticlesDatabase
    ) = database.MostViewedArticleDao()

    @Singleton
    @Provides
    fun provideNYtimesApi(): NYtimesAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(NYtimesAPI::class.java)
    }

}