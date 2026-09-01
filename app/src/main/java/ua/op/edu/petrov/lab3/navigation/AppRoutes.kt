package ua.op.edu.petrov.lab3.navigation

object AppRoutes {
    const val PLACES = "places"
    const val ADD_PLACE = "add_place"
    const val PLACE_ID = "placeId"
    const val DETAILS = "details/{$PLACE_ID}"

    fun details(placeId: Long): String = "details/$placeId"
}
