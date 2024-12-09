package semerci.enis.toptanc.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import semerci.enis.toptanc.data.CKANRecord

@Composable
fun HalScreen(viewModel: HalViewModel = viewModel()) {
    val state by viewModel.state

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { viewModel.setFilter("SEBZE") }) {
                Text("Sebze")
            }
            Button(onClick = { viewModel.setFilter("MEYVE") }) {
                Text("Meyve")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Surface(modifier = Modifier.fillMaxSize()) {
            when (val currentState = state) {
                is HalViewModel.HalUiState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                is HalViewModel.HalUiState.Success -> {
                    LazyColumn {
                        items(currentState.products) { product ->
                            ProductItem(product = product)
                        }
                    }
                }
                is HalViewModel.HalUiState.Error -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = currentState.message, color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: CKANRecord) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Tarih: ${product.TARIH ?: "-"}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Mal Türü: ${product.MAL_TURU ?: "-"}")
            Text(text = "Mal Adı: ${product.MAL_ADI ?: "-"}")
            Text(text = "Birim: ${product.BIRIM ?: "-"}")
            Text(text = "Asgari Fiyat: ${product.ASGARI_UCRET ?: "-"}")
            Text(text = "Azami Fiyat: ${product.AZAMI_UCRET ?: "-"}")
            Text(text = "Ortalama Fiyat: ${product.ORTALAMA_UCRET  ?: "-"}")
        }
    }
}