package ua.op.edu.petrov.lab3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ua.op.edu.petrov.lab3.model.TravelPlace

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetailsScreen(
    place: TravelPlace?,
    onBack: () -> Unit,
    onDelete: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Деталі місця") })
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Назад")
            }

            if (place == null) {
                Text("Місце з переданим id не знайдено.")
            } else {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = place.country,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = "ID, переданий через навігацію: ${place.id}",
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    text = place.description,
                    style = MaterialTheme.typography.bodyLarge,
                )

                Button(
                    onClick = onDelete,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Видалити")
                }
            }
        }
    }
}
