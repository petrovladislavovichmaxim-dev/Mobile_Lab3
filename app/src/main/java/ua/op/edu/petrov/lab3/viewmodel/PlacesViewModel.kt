package ua.op.edu.petrov.lab3.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ua.op.edu.petrov.lab3.model.PlacesUiState
import ua.op.edu.petrov.lab3.model.TravelPlace

class PlacesViewModel : ViewModel() {

    private var nextId = 4L

    private val _uiState = MutableStateFlow(
        PlacesUiState(
            places = listOf(
                TravelPlace(
                    id = 1,
                    name = "Карпати",
                    country = "Україна",
                    description = "Гірські маршрути, ліси та краєвиди для активного відпочинку.",
                ),
                TravelPlace(
                    id = 2,
                    name = "Прага",
                    country = "Чехія",
                    description = "Історичний центр, Карлів міст та середньовічна архітектура.",
                ),
                TravelPlace(
                    id = 3,
                    name = "Рим",
                    country = "Італія",
                    description = "Колізей, Римський форум і пам'ятки античної культури.",
                ),
            )
        )
    )

    val uiState: StateFlow<PlacesUiState> = _uiState.asStateFlow()

    fun getPlace(id: Long): TravelPlace? =
        _uiState.value.places.firstOrNull { it.id == id }

    fun addPlace(name: String, country: String, description: String): Boolean {
        val cleanName = name.trim()
        val cleanCountry = country.trim()
        val cleanDescription = description.trim()
        if (cleanName.isEmpty() || cleanCountry.isEmpty()) return false

        val newPlace = TravelPlace(
            id = nextId++,
            name = cleanName,
            country = cleanCountry,
            description = cleanDescription.ifEmpty { "Опис не вказано." },
        )
        _uiState.value = _uiState.value.copy(
            places = _uiState.value.places + newPlace
        )
        return true
    }

    fun removePlace(id: Long) {
        _uiState.value = _uiState.value.copy(
            places = _uiState.value.places.filterNot { it.id == id }
        )
    }
}
