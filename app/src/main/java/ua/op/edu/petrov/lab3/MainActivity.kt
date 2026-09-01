package ua.op.edu.petrov.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ua.op.edu.petrov.lab3.navigation.TravelPlacesApp
import ua.op.edu.petrov.lab3.ui.theme.PetrovLab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetrovLab3Theme {
                TravelPlacesApp()
            }
        }
    }
}
