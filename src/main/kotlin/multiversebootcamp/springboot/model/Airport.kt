package multiversebootcamp.springboot.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Airport(
    val name: String,
    val icao: String,
    val iata: String? = null,
    val city: String? = null,
    val state: String? = null,
    val country: String? = null,
    val elevation: Int? = null,
    @Contextual val lat: Number? = null,
    @Contextual val lon: Number? = null,
    val tz: String? = null,
    @Contextual val date: LocalDate = LocalDate.now()
)
