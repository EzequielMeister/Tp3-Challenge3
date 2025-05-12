package com.example.tp3challenge3.network

import com.example.tp3challenge3.model.Quote
import retrofit2.http.GET
import retrofit2.http.Headers

// define la interfaz de Retrofit(es una biblioteca de Android para manejar solicitudes HTTP de forma sencilla.)


interface QuoteApiService {
    @GET("/v1/quotes")
    @Headers("X-Api-Key: ")
    suspend fun getQuotes(): List<Quote>
}