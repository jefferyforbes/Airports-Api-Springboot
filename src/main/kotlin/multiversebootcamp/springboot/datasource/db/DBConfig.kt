package multiversebootcamp.springboot.datasource.db

import kotlinx.coroutines.*
import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.Bank
import multiversebootcamp.springboot.models.User
import org.litote.kmongo.KMongo.createClient
import org.litote.kmongo.getCollection
import org.springframework.context.annotation.Configuration

@Configuration
class DBConfig() {
    private val baseURL = System.getenv("AirportsDB")
    private val client = createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val baseUserPass = System.getenv("mainAdminPassword")
    private val airportsCol = database.getCollection<Airport>()
    private val usersCol = database.getCollection<User>()
    private val banksCol = database.getCollection<Bank>()
}