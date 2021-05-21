package multiversebootcamp.springboot.datasource.initial

import kotlinx.coroutines.runBlocking
import multiversebootcamp.springboot.models.Bank
import org.bson.types.ObjectId
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*

@Component
class InitialBanks() {

    private val baseURL = System.getenv("AirportsDB")
    private val client = KMongo.createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val baseUserPass = System.getenv("mainAdminPassword")
    private val bankCol = database.getCollection<Bank>()

    private val bankQ = bankCol.findOne(Bank::accountNumber eq 123456789)
    private val banksEntry = runBlocking {
        if (bankQ == null) {
            bankCol.insertOne(
                Bank(
                    ObjectId.getSmallestWithDate(Date.from(Instant.now())),
                    accountNumber = 123456789,
                    passcode = 987654321,
                    balance = 1000000,
                    standingOrder = null
                )
            )
        } else {
            println("${bankQ.accountNumber} already exists!!!")
        }
    }
}