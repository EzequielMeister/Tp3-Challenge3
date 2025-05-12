package com.example.tp3challenge3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tp3challenge3.ui.theme.Tp3Challenge3Theme
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import com.example.tp3challenge3.viewmodel.QuoteViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val viewModel: QuoteViewModel by viewModels()
        viewModel.loadQuotes()

        setContent {
            Tp3Challenge3Theme {
                val quote by viewModel.quote.collectAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (quote != null) {
                        Greeting(
                            quote = quote!!.quote,
                            author = quote!!.author,
                            category = quote!!.category,
                            modifier = Modifier.padding(innerPadding),
                            refresh = { viewModel.loadQuotes() }
                        )
                    } else {
                        Text("Cargando...")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(quote: String, author: String, category: String, modifier: Modifier = Modifier, refresh: () -> Unit) {
    Column(modifier = modifier.padding(16.dp)) {
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = "Frase: $quote")
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = "Autor:  $author")
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = "Categoría: $category")
        }
        Row(modifier = Modifier.padding(8.dp)) {
            Button(onClick = refresh) {
                Text(text = "Refresh")
            }
        }
    }
}

