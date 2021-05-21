package multiversebootcamp.springboot.datasource.db

import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.User
import org.bson.types.ObjectId
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Component
class MockDataSource {
    val mockUserDB = mutableListOf(
        User(
            ObjectId.getSmallestWithDate(Date.from(Instant.now())),
            name = "mock-name",
            username = "mock-user",
            password = "mock-password",
            role = "mock-user"
        )
    )

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