package semerci.enis.toptanc.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import kotlinx.coroutines.launch
import semerci.enis.toptanc.data.CKANRecord
import semerci.enis.toptanc.data.HalRepository

class HalViewModel : ViewModel() {

    private val repository = HalRepository()

    private val _state = mutableStateOf<HalUiState>(HalUiState.Loading)
    val state: State<HalUiState> = _state

    init {
        fetchHalData(limit = 100, query = null, filtersJson = null)
    }

    fun setFilter(malTuru: String) {
        val filtersJson = """{"MAL_TURU":"$malTuru"}"""
        fetchHalData(filtersJson = filtersJson)
    }

    private fun fetchHalData(limit: Int = 100, query: String? = null, filtersJson: String? = null) {
        _state.value = HalUiState.Loading
        viewModelScope.launch {
            try {
                val data = repository.getHalData(limit = limit, query = query, filtersJson = filtersJson)
                if (data.isNotEmpty()) {
                    _state.value = HalUiState.Success(data)
                } else {
                    _state.value = HalUiState.Error("Veri bulunamadı.")
                }
            } catch (e: Exception) {
                _state.value = HalUiState.Error("Hata: ${e.localizedMessage}")
            }
        }
    }

    sealed class HalUiState {
        object Loading : HalUiState()
        data class Success(val products: List<CKANRecord>) : HalUiState()
        data class Error(val message: String) : HalUiState()
    }
}