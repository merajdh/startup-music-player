package com.example.startup_music_player.model.net

import com.example.startup_music_player.model.data.*
import com.example.startup_music_player.model.repository.TokenInMemory

import com.google.gson.JsonObject
import com.google.gson.annotations.JsonAdapter
import ir.dunijet.dunibazaar.util.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

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
    suspend fun CategoryArtist() : List<ListArtistData>

    @GET("accounts/profile/artist/{id}")
    suspend fun ArtistDetail(@Path("id") id_Artist : String) : DetailArtistRespomse

    @GET("music/category/detail/{id}")
    suspend fun MusicByCategory(@Path("id") id_category : String) : List<MusicByCategoryData>

    @GET("music/favoritemusic/{id}")
    suspend fun Favoritemusic(@Path("id") id_User : String) : List<MusicRespomse>

    @POST("music/favoritemusic/add")
    suspend fun FavoritemusicAdd(@Body jsonObject: JsonObject) : LikeRespomse

    @GET("page/ticket-title")
    suspend fun TitleTicket() : List<TitleTicket>

    @GET("music/search")
    suspend fun search(@Query("search") namemusik :String) : List<MusicRespomse>

    @PUT("accounts/password/update")
    suspend fun UpdatePaswoord(@Body body: JsonObject) : LoginRespomse

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