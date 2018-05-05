package com.mustafafidan.youtubeclonemvppattern.api

import com.mustafafidan.youtubeclonemvppattern.model.Response
import io.reactivex.Observable
import retrofit2.http.*
import java.util.*

interface YoutubeApi {



    @GET("/youtube/v3/search")
    fun search(@QueryMap searchMap: Map<String,String>) : Observable<Response>
}