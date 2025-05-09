package com.example.tp3challenge3.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// responsable de crear una instancia de Retrofit.
// Esta instancia se utiliza para realizar solicitudes HTTP a la API de quotes.

//Retrofit se configura con la base URL de la API y un convertidor (GsonConverterFactory)
// que convierte las respuestas JSON a objetos Kotlin.

object RetrofitClient {
    private const val BASE_URL = "https://api.api-ninjas.com/"  // CAMBIARLA

    val apiService: QuoteApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApiService::class.java)
    }
}