package multiversebootcamp.springboot.datasource.dao

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
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
class UserDAOImpl(private val passVerifier: PasswordUtil) : UserDAO {
    private val baseURL = System.getenv("AirportsDB")
    private val mainAccPass = System.getenv("mainAdminPassword")
    private val client = KMongo.createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val userCol = database.getCollection<User>()

    override fun retrieveUsers(): List<User> {
        return userCol.find().toList()
    }

    override fun retrieveUser(user: User): ResponseEntity<Any> {
        val userQ = userCol.findOne(User::username eq user)
            ?: return ResponseEntity.badRequest().body("user not found")
        return ResponseEntity.ok(userQ)
    }

    override fun createUser(user: User) {
        userCol.insertOne(user)
    }

    override fun updateUser(user: User) {
        userCol.findOneAndReplace(User::username eq user.username, User(
            user._id,
            name = user.name,
            username = user.username,
            password = user.password,
            role = user.role
        ))
    }

    override fun removeUser(user: User) {
        userCol.findOneAndDelete(User::username eq user.username)
    }

    override fun loginReq(user: User): ResponseEntity<Any> {
        val userQ = userCol.findOne(User::username eq user.username)
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
}