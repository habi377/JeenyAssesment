package com.habib.jeenyassesment.data.remote

import com.habib.jeenyassesment.BuildConfig
import com.habib.jeenyassesment.data.remote.models.BaseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NYtimesAPI {

    companion object {
        private const val PARAM_PERIOD = "period"
        private const val MOST_VIEWED = "/svc/mostpopular/v2/viewed/{$PARAM_PERIOD}.json"
    }

    @GET(MOST_VIEWED)
    suspend fun getMostViewed(
        @Path(PARAM_PERIOD) period : Int,
        @Query("api-key") apiKey : String = BuildConfig.API_KEY
    ): BaseModel
}