package multiversebootcamp.springboot.datasource.initial

import kotlinx.coroutines.runBlocking
import multiversebootcamp.springboot.models.Airport
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import java.time.LocalDate
import java.time.LocalDateTime

class InitialAirports {

    private val baseURL = System.getenv("AirportsDB")
    private val client = KMongo.createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val baseUserPass = System.getenv("mainAdminPassword")
    private val airportCol = database.getCollection<Airport>()

    private val airportQ = airportCol.findOne(Airport::icao eq "EGSS")
    private val airportQ2 = airportCol.findOne(Airport::icao eq "LHR")
    private val airportQ3 = airportCol.findOne(Airport::icao eq "GLA")
    private val airportQ4 = airportCol.findOne(Airport::icao eq "LGW")

    private val initialAirports = runBlocking {
        if (airportQ == null) {
            Airport(
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
        } else {
            println("${airportQ.name} already exists!!!")
        }

        if (airportQ2 == null) {
            Airport(
                name = "London Heathrow Airport",
                icao = "LHR",
            )
        } else {
            println("${airportQ2.name} already exists!!!")
        }

        if (airportQ3 == null) {
            Airport(
                name = "Glasgow Airport",
                icao = "GLA",
            )
        } else {
            println("${airportQ3.name} already exists!!!")
        }

        if (airportQ4 == null) {
            Airport(
                name = "London Gatwick Airport",
                icao = "LGW",
            )
        } else {
            println("${airportQ4.name} already exists!!!")
        }
    }
}