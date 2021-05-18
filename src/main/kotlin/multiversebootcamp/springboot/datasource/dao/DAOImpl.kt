package multiversebootcamp.springboot.datasource.dao

import com.mongodb.client.FindIterable
import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.User
import org.litote.kmongo.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository

@Repository
class DAOImpl : DAO {
    private val baseURL = System.getenv("AirportsDB")
    private val client = KMongo.createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val airportsCollection = database.getCollection<Airport>()
    private val userCollection = database.getCollection<User>()

    override fun retrieveUsers(): List<User> {
        return userCollection.find().toList()
    }

    override fun retrieveUser(username: String): User? {
        return userCollection.findOne(User::username eq username)
    }

    override fun createUser(user: User): User {
        TODO("Not yet implemented")
    }

    override fun updateUser(username: String): User {
        TODO("Not yet implemented")
    }

    override fun removeUser(username: String) {
        TODO("Not yet implemented")
    }

    override fun updateAirport(icao: String): Airport {
        TODO("Not yet implemented")
    }

    override fun retrieveAirports(): Collection<Airport> {
        return airportsCollection.find().toList()
    }

    override fun retrieveAirport(icao: String): Airport? {
        return airportsCollection.findOne(Airport::icao eq icao)
    }

    override fun createAirport(airport: Airport): Airport {
        TODO("Not yet implemented")
    }

    override fun removeAirport(icao: String) {
        TODO("Not yet implemented")
    }
}