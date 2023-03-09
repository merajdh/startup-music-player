package com.example.startup_music_player.model.net

import com.example.startup_music_player.model.data.LoginRespomse
import com.example.startup_music_player.model.data.MusicRespomse
import com.google.gson.JsonObject
import ir.dunijet.dunibazaar.util.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface Apiservice {

    @POST("accounts/login")
    suspend fun Login(@Body jsonObject: JsonObject): LoginRespomse

    @POST("Register")
    suspend fun Register(@Body jsonObject: JsonObject): LoginRespomse

    @POST("Verify")
    suspend fun Verify(@Body jsonObject: JsonObject): LoginRespomse

    @GET("refreshToken")
    fun refreshToken(): Call<LoginRespomse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjc4NDUxMTI3LCJpYXQiOjE2NzgzNjQ3MjcsImp0aSI6ImMwNjNlYWM1MTlhZDQ3NTFhMWIxYjI0MzczYzRkMWYxIiwidXNlcl9pZCI6M30.4USFe6WKLhfCFT70X6B4LqNvPe9SfEg4rrlIg-GsofM")
    @GET("music/musicbycategory/")
    suspend fun MusicByCategory(): List<MusicRespomse>

    @GET("music/morelike/")
    suspend fun MoreLike(): List<MusicRespomse>

    @GET("music/recentmusic/")
    suspend fun RecentMusik(): List<MusicRespomse>

    @GET("music/trendmusic/")
    suspend fun TrendMusik(): List<MusicRespomse>
}

fun createApiService(): Apiservice {

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(Apiservice::class.java)
}