package multiversebootcamp.springboot.datasource.dao

import com.mongodb.client.result.UpdateResult
import multiversebootcamp.springboot.models.Bank
import org.apache.catalina.connector.Response
import org.litote.kmongo.*
import org.springframework.context.annotation.Primary
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository

@Repository
@Primary
class BankDAOImpl : BankDAO {

    private val baseURL = System.getenv("AirportsDB")
    private val mainAccPass = System.getenv("mainAdminPassword")
    private val client = KMongo.createClient(baseURL)
    private val database = client.getDatabase("Airports")
    private val banksCol = database.getCollection<Bank>()

    override fun createAccount(bank: Bank): String {
        val bankQ = banksCol.findOne(Bank::accountNumber eq bank.accountNumber)
        return if (bankQ == null) {
            banksCol.insertOne(bank)
            "Bank account ${bank.accountNumber} created"
        } else {
            "Account number ${bank.accountNumber} already exists in Database."
        }
    }

    override fun getAccount(accountNumber: Int): Bank? {
        val bankQ = banksCol.findOne(Bank::accountNumber eq accountNumber)
        return bankQ
    }

    override fun getBalance(accountNumber: Int): String? {
        val bankQ = banksCol.findOne(Bank::accountNumber eq accountNumber)
        return "Balance: ${bankQ?.balance}"
    }

    override fun getStandingOrders(accountNumber: Int): String {
        val bankQ = banksCol.findOne(Bank::accountNumber eq accountNumber)
        val ordersQ = bankQ?.standingOrder?.toList()
        return ordersQ?.toString() ?: "Account number ${bankQ?.accountNumber} has no standing orders"
    }

    override fun createStandingOrder(accountNumber: Int, order: String) {
        val bankQ = banksCol.findOne(Bank::accountNumber eq accountNumber)
        val bankUpdate = bankQ?._id?.let { banksCol.updateOneById(it, order) }
        banksCol.updateOne(
            Bank::accountNumber eq bankQ?.accountNumber, setValue(Bank::accountNumber, order)
        )
    }

    override fun sendMoney(senderAccount: Bank, receiptent: Bank, amount: Int) {
        val sender = banksCol.findOne(Bank::accountNumber eq senderAccount.accountNumber)
        val receiver = banksCol.findOne(Bank::accountNumber eq receiptent.accountNumber)
        if (senderAccount.balance < amount) {
            "Sorry, you do not have enough to cover this transfer."
        } else {
            sender?.balance!!.minus(amount)
            receiver?.balance!!.plus(amount)
        }
    }

    override fun getAllBanks(): List<Bank> {
        val bankQ = banksCol.find().toList()
        return bankQ
    }

    override fun login(bank: Bank) {
        TODO("Not yet implemented")
    }
}