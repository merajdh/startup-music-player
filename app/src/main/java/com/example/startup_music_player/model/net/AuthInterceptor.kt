package com.example.startup_music_player.model.net


import android.util.Log
import com.example.startup_music_player.model.repository.TokenInMemory
import com.google.gson.JsonObject
import ir.dunijet.dunibazaar.util.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthInterceptor(private val authService: Apiservice) : Interceptor {
    private var authToken: String? = null

    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        
        // If the authToken is null or empty, get a new one
        if (authToken.isNullOrEmpty()) {
            authToken = TokenInMemory.access
        }

        // Add the authToken to the header of the request
        request = request.newBuilder()
            .header("Authorization", "Bearer ${TokenInMemory.access}")
            .build()

        // Execute the request
        var response = chain.proceed(request)

        // If the response is a 401 error, try to refresh the authToken
        if (response.code == 401) {

            synchronized(this) {
                // Double check if authToken is still null or expired before refreshing
                if (authToken.isNullOrEmpty()) {
                    authToken = TokenInMemory.access
                }

                // Use the refresh token to get a new authToken
                val jsonObject = JsonObject().apply {
                    addProperty("refresh", TokenInMemory.refresh)
                }
                val newAuthToken = authService.refreshToken(jsonObject).toString()

                // If the newAuthToken is not null or empty, update the authToken variable
                if (!newAuthToken.isNullOrEmpty()) {
                    authToken = newAuthToken
                }

                // Add the new authToken to the header of the request
                request = request.newBuilder()
                    .header("Authorization", "Bearer $authToken")
                    .build()

                // Retry the original request with the new authToken
                response.close()
                response = chain.proceed(request)
            }
        }

        return response
    }
}

val authService = createApiService() // Your AuthService class that handles getting and refreshing the authToken
val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(AuthInterceptor(authService))
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(Apiservice::class.java)
