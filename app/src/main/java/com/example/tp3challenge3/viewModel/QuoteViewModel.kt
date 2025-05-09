package com.example.tp3challenge3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3challenge3.model.Quote
import com.example.tp3challenge3.repository.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


// Aca se maneja la lógica de la UI y los datos.
// El ViewModel es una clase que está diseñada para almacenar y manejar los datos
// de la UI de manera que sobrevivan a cambios de configuración como rotaciones de pantalla.

class QuoteViewModel : ViewModel() {

    private val repository = QuoteRepository()

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> get() = _quote

    fun loadQuotes() {
        viewModelScope.launch {
            val quotes = repository.getQuotes()
            if (quotes.isNotEmpty()) {
                _quote.value = quotes.random()
            }
        }
    }
}
