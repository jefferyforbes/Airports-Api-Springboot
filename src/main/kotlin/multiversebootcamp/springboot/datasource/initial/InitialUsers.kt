package multiversebootcamp.springboot.datasource.initial

import kotlinx.coroutines.runBlocking
import multiversebootcamp.springboot.models.User
import multiversebootcamp.springboot.utils.passwordutil.PasswordUtil
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class InitialUsers(eCryp: PasswordUtil, bcrypt: BCryptPasswordEncoder) {

    private val baseURL = System.getenv("AirportsDB")
    private val client = KMongo.createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val baseUserPass = System.getenv("mainAdminPassword")
    private val userCol = database.getCollection<User>()

    private val userQ = userCol.findOne(User::username eq "mainAccount")
    private val userEntry = runBlocking {
        if (userQ == null) {
            userCol.insertOne(
                User(
                    name = "Jeffery Forbes",
                    username = "mainAccount",
                    password = eCryp.encrypt(bcrypt, System.getenv("mainAdminPassword")),
                    role = "admin")
            )
        } else println("${userQ.username} already exists!!!")
    }
}