package multiversebootcamp.springboot.model

data class Airport(
    val icao: String,
    val iata: String,
    val name: String,
    val city: String,
    val state: String,
    val country: String,
    val elevation: Int,
    val lat: Number,
    val lon: Number,
    val tz: String,
)
