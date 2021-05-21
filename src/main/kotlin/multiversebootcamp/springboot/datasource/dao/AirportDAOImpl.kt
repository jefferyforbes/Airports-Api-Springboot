package multiversebootcamp.springboot.datasource.dao

import multiversebootcamp.springboot.models.Airport
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.stereotype.Repository

@Repository
class AirportDAOImpl : AirportDAO {

    private val baseURL = System.getenv("AirportsDB")
    private val mainAccPass = System.getenv("mainAdminPassword")
    private val client = KMongo.createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val airportsCol = database.getCollection<Airport>()

    override fun retrieveAirports(): List<Airport> {
        return airportsCol.find().toList()
    }

    override fun retrieveAirport(airport: Airport): Airport? {
        return airportsCol.findOne(Airport::icao eq airport.icao)
    }

    override fun createAirport(airport: Airport) {
        val airportQ = airportsCol.findOne(Airport::icao eq airport.icao)
        if (airportQ == null) {
            airportsCol.insertOne(airport)
        } else {
            "Error, this airport already exists!"
        }
    }

    override fun updateAirport(airport: Airport) {
        airportsCol.findOneAndReplace(Airport::icao eq airport.icao, Airport(
            airport._id,
            name = airport.name,
            icao = airport.icao,
            iata = airport.iata,
            city = airport.city,
            state = airport.state,
            country = airport.country,
            elevation = airport.elevation,
            lat = airport.lat,
            lon = airport.lon,
            tz = airport.tz,
        ))
    }

    override fun removeAirport(airport: Airport) {
        airportsCol.findOneAndDelete(Airport::icao eq airport.icao)
    }
}