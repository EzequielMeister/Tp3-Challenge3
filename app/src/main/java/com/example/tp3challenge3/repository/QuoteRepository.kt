package com.example.tp3challenge3.repository

import com.example.tp3challenge3.model.Quote
import com.example.tp3challenge3.network.RetrofitClient

//  Se maneja la lógica para obtener los datos de la API. Se
//  invoca el servicio de Retrofit para obtener las quotes

class QuoteRepository {
    suspend fun getQuotes(): List<Quote> {
        return RetrofitClient.apiService.getQuotes()
    }
}
