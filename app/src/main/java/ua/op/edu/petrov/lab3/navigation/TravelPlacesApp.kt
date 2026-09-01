package ua.op.edu.petrov.lab3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ua.op.edu.petrov.lab3.ui.AddPlaceScreen
import ua.op.edu.petrov.lab3.ui.PlaceDetailsScreen
import ua.op.edu.petrov.lab3.ui.PlacesListScreen
import ua.op.edu.petrov.lab3.viewmodel.PlacesViewModel

@Composable
fun TravelPlacesApp(viewModel: PlacesViewModel = viewModel()) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.PLACES,
    ) {
        composable(AppRoutes.PLACES) {
            PlacesListScreen(
                places = uiState.places,
                onPlaceClick = { placeId ->
                    navController.navigate(AppRoutes.details(placeId))
                },
                onAddClick = {
                    navController.navigate(AppRoutes.ADD_PLACE)
                },
            )
        }

        composable(
            route = AppRoutes.DETAILS,
            arguments = listOf(
                navArgument(AppRoutes.PLACE_ID) {
                    type = NavType.LongType
                }
            ),
        ) { backStackEntry ->
            val placeId = backStackEntry.arguments
                ?.getLong(AppRoutes.PLACE_ID)
                ?: -1L

            PlaceDetailsScreen(
                place = viewModel.getPlace(placeId),
                onBack = { navController.popBackStack() },
                onDelete = {
                    viewModel.removePlace(placeId)
                    navController.popBackStack()
                },
            )
        }

        composable(AppRoutes.ADD_PLACE) {
            AddPlaceScreen(
                onBack = { navController.popBackStack() },
                onSave = { name, country, description ->
                    if (viewModel.addPlace(name, country, description)) {
                        navController.popBackStack()
                    }
                },
            )
        }
    }
}
