package com.example.startup_music_player.model.net

import com.example.startup_music_player.model.data.LoginRespomse
import com.example.startup_music_player.model.data.MusicRespomse
import com.example.startup_music_player.model.repository.TokenInMemory
import com.google.gson.JsonObject
import ir.dunijet.dunibazaar.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
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

    @GET("Music")
    suspend fun Music(): List<MusicRespomse>



}

fun createApiService(): Apiservice {

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(Apiservice::class.java)
}