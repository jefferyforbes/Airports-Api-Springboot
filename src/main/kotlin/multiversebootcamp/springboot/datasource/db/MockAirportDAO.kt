package multiversebootcamp.springboot.datasource.db

import multiversebootcamp.springboot.models.Airport
import org.bson.types.ObjectId
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class MockAirportDAO {
    val mockAirportDB = mutableListOf<Airport>(
        Airport(
            ObjectId.getSmallestWithDate(Date.from(Instant.now())),
            name = "London Stanstead Airport",
            icao = "EGSS",
            iata = "STN",
            city = null,
            state = null,
            country = null,
            elevation = null,
            lat = null,
            lon = null,
            tz = null,
            date = LocalDate.now(),
            time = LocalDateTime.now()
        )
    )
}