package multiversebootcamp.springboot.datasource.db

import kotlinx.coroutines.*
import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.User
import multiversebootcamp.springboot.utils.passwordutil.PasswordUtil
import org.litote.kmongo.KMongo.createClient
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
class DBConfig(eCryp: PasswordUtil, bcrypt: BCryptPasswordEncoder) {

    private val baseURL = System.getenv("AirportsDB")
    private val client = createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val baseUserPass = System.getenv("mainAdminPassword")
    private val airportsCol = database.getCollection<Airport>()
    private val userCol = database.getCollection<User>()

    private val initialEntry = runBlocking {
        // This block of code runs on the server creation to ensure that there is at least one entry in MongoDb
        airportsCol.insertOne(Airport(name = "London Heathrow", icao = "LHR"))
        airportsCol.insertOne(Airport(name = "Glasgow Airport", icao = "GLA"))
        airportsCol.insertOne(Airport(name = "Gatwick Airport", icao = "LGW"))
        // At runtime this gets inserted in the DB regardless of if it exists ->
        /* TODO: Impl a document validation which checks that any airport with both name and icao is not inserted in the
        *   and clears any previous duplications as well. */
    }

    private val userInitialEntry = runBlocking {
        val userQ = userCol.findOne(User::username eq "mainAccount")
        if (userQ == null) {
            userCol.insertOne(
                User(
                    name = "Jeffery Forbes",
                    username = "mainAccount",
                    password = eCryp.encrypt(bcrypt, System.getenv("mainAdminPassword")),
                    role = "admin")
            )
        } else println("mainAccount User already exists!!!")
    }
}