package ua.op.edu.petrov.lab3.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlaceScreen(
    onBack: () -> Unit,
    onSave: (String, String, String) -> Unit,
) {
    var name by rememberSaveable { mutableStateOf("") }
    var country by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Нове місце") })
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Назва") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )
            OutlinedTextField(
                value = country,
                onValueChange = { country = it },
                label = { Text("Країна") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Опис") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3,
            )
            Button(
                onClick = { onSave(name, country, description) },
                enabled = name.isNotBlank() && country.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Зберегти")
            }
            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Скасувати")
            }
        }
    }
}
