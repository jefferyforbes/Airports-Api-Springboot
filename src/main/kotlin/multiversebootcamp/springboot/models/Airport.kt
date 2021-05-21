package multiversebootcamp.springboot.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId
import java.time.LocalDate
import java.time.LocalDateTime

@Serializable
data class Airport(
    @Contextual val _id: ObjectId? = null,
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
    @Contextual val date: LocalDate = LocalDate.now(),
    @Contextual val time: LocalDateTime = LocalDateTime.now()
)
