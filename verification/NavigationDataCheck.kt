data class TravelPlace(val id: Long, val name: String, val country: String)

class Store {
    private var nextId = 3L
    var places = listOf(
        TravelPlace(1, "A", "UA"),
        TravelPlace(2, "B", "CZ"),
    )
        private set

    fun byId(id: Long) = places.firstOrNull { it.id == id }
    fun add(name: String, country: String) {
        places = places + TravelPlace(nextId++, name, country)
    }
    fun remove(id: Long) {
        places = places.filterNot { it.id == id }
    }
}

fun detailsRoute(id: Long) = "details/$id"

fun main() {
    val store = Store()
    check(detailsRoute(2) == "details/2")
    check(store.byId(2)?.name == "B")
    store.add("C", "IT")
    check(store.byId(3)?.country == "IT")
    store.remove(1)
    check(store.byId(1) == null)
    println("Lab3 logic OK: ${store.places.size} items, route=${detailsRoute(3)}")
}
