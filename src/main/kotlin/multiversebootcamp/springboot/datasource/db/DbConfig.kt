package multiversebootcamp.springboot.datasource.db

import kotlinx.coroutines.runBlocking
import multiversebootcamp.springboot.model.Airport
import org.litote.kmongo.KMongo.createClient
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.context.annotation.Configuration


@Configuration
class DbConfig {
    // TODO: The baseURL should be moved to a env file to prevent exposing the read/write access to the public
    private val baseURL =
        "mongodb+srv://airportsAdmin:airportsPassword@airportsapi." +
                "ly82k.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"
    private val client = createClient(baseURL)
    private val database = client.getDatabase("AirportsAPI")
    private val airportsCol = database.getCollection<Airport>()
    private val initialEntry = runBlocking {
        // This block of code runs on the server creation to ensure that there is at least one entry in MongoDb
        // TODO: Refactor this block to initialise 3 Airports instead in a separate file
        airportsCol.insertOne(Airport(name = "London Heathrow", icao = "LHR"))
        val testLHR: Airport? = airportsCol.findOne(Airport::name eq "London Heathrow")
        // At runtime this gets inserted in the DB regardless of if it exists ->
        /* TODO: Impl a document validation which checks that any airport with both name and icao is not inserted in the
        *   and clears any previous duplications as well. */
    }
}