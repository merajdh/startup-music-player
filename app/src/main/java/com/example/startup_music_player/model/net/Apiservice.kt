package com.example.startup_music_player.model.net

import com.example.startup_music_player.model.data.LoginRespomse
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.repository.TokenInMemory
import com.example.startup_music_player.util.MyApp
import com.example.startup_music_player.util.MyApp.Companion.access
import com.google.gson.JsonObject
import ir.dunijet.dunibazaar.util.BASE_URL
import okhttp3.OkHttpClient
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

    @GET("music/musicbycategory/")
    suspend fun MusicByCategory(): List<MusicRespomse>


    @GET("music/recentmusic/")
    suspend fun MusicNews(): List<MusicRespomse>


    @GET("music/musicbycategory/")
    suspend fun MusicTop(): List<MusicRespomse>


    @GET("music/recentmusic/")
    suspend fun MusicTrend(): List<MusicRespomse>

    @GET("music/internationals/")
    suspend fun MusicInternatioal() : List<MusicRespomse>
}

fun createApiService(): Apiservice {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {

            val oldRequest = it.request()
            val newRequest = oldRequest.newBuilder()
            if (TokenInMemory.access !=""){
                newRequest.addHeader("Authorization","Bearer ${TokenInMemory.access}")
                newRequest.method(oldRequest.method(), oldRequest.body())
            }



            return@addInterceptor it.proceed(newRequest.build())
        }.build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(Apiservice::class.java)
}