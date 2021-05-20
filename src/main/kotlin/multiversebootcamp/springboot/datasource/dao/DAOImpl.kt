package multiversebootcamp.springboot.datasource.dao

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import multiversebootcamp.springboot.models.Airport
import multiversebootcamp.springboot.models.User
import multiversebootcamp.springboot.utils.passwordutil.PasswordUtil
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class DAOImpl(private val passVerifier: PasswordUtil) : DAO {
    private val baseURL = System.getenv("AirportsDB")
    private val mainAccPass = System.getenv("mainAdminPassword")
    private val client = KMongo.createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val airportsCollection = database.getCollection<Airport>()
    private val userCollection = database.getCollection<User>()

    override fun retrieveUsers(): List<User> {
        return userCollection.find().toList()
    }

    override fun retrieveUser(user: User): ResponseEntity<Any> {
        val userQ = userCollection.findOne(User::username eq user)
            ?: return ResponseEntity.badRequest().body("user not found")

        return ResponseEntity.ok(userQ)
    }

    override fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun removeUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun loginReq(user: User): ResponseEntity<Any> {
        val userQ = userCollection.findOne(User::username eq user.username)
        val passQ = userQ?.password
        val passV = passVerifier.passwordCompare(
            passwordEncoder = BCryptPasswordEncoder(),
            existPassword = passQ,
            inputPassword = user.password
        )

        val issuer = userQ?._id.toString()
        print(issuer)

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 1 * 1000)) // 1 Hour
            .signWith(SignatureAlgorithm.ES256, "secretkey").compact()
        return ResponseEntity.ok("$user | $jwt") // ERROR
    }

    override fun updateAirport(airport: Airport) {
        TODO("Not yet implemented")
    }

    override fun retrieveAirports(): List<Airport> {
        return airportsCollection.find().toList()
    }

    override fun retrieveAirport(airport: Airport): Airport? {
        return airportsCollection.findOne(Airport::icao eq airport)
    }

    override fun createAirport(airport: Airport) {
        TODO("Not yet implemented")
    }

    override fun removeAirport(airport: Airport) {
        TODO("Not yet implemented")
    }
}