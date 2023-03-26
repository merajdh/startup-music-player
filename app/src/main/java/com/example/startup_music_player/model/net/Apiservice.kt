package com.example.startup_music_player.model.net

import com.example.startup_music_player.model.data.*
import com.example.startup_music_player.model.repository.TokenInMemory

import com.google.gson.JsonObject
import ir.dunijet.dunibazaar.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Apiservice {

    @POST("accounts/login")
    suspend fun Login(@Body jsonObject: JsonObject): LoginRespomse

    @POST("accounts/register")
    suspend fun Register(@Body jsonObject: JsonObject): LoginRespomse

    @POST("accounts/check")
    suspend fun Verify(@Body jsonObject: JsonObject): LoginRespomse

    @POST("accounts/refresh/")
    fun refreshToken(@Body jsonObject: JsonObject): Call<LoginRespomse>

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


    @GET("music/detail/{id}/")
    suspend fun MusicPlay(@Path("id") id_Musik : String) : MusicDetail

    @GET("music/category/")
    suspend fun CategoryTypeMusic() : List<CategoryRespomse>

    @GET("accounts/artists/")
    suspend fun CategoryArtist(): List<ArtistData>
}

fun createApiService(): Apiservice {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {

            val oldRequest = it.request()
            val newRequest = oldRequest.newBuilder()
            if (TokenInMemory.access !=""){
                newRequest.addHeader("Authorization","Bearer ${TokenInMemory.access}")
                newRequest.method(oldRequest.method, oldRequest.body)
            }

            return@addInterceptor it.proceed(newRequest.build())
        }
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(Apiservice::class.java)
}