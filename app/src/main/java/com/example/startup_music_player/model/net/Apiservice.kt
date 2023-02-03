package com.example.startup_music_player.model.net

import android.util.Log
import com.example.startup_music_player.model.data.LoginRespomse
import com.example.startup_music_player.model.repository.TokenInMemory
import com.google.gson.Gson
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

    @POST("Login")
   suspend fun Login(@Body jsonObject: JsonObject) : LoginRespomse

    @POST("Register")
    suspend fun Register(@Body jsonObject: JsonObject) : LoginRespomse

    @GET("refreshToken")
    fun refreshToken(): Call<LoginRespomse>

}
fun createApiService(): Apiservice{
    val okHttpClient =  OkHttpClient.Builder()
        .addInterceptor {
            val  oldRetrofit = it.request()
            val newRetrofit = oldRetrofit.newBuilder()
            if (TokenInMemory.Token != null)
                newRetrofit.addHeader("",TokenInMemory.Token!!)

            newRetrofit.method(oldRetrofit.method(),oldRetrofit.body())
            return@addInterceptor it.proceed(newRetrofit.build())
        }.build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(Apiservice::class.java)
}