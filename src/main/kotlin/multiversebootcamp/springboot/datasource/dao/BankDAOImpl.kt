package multiversebootcamp.springboot.datasource.dao

import multiversebootcamp.springboot.models.Bank
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

    override fun createAccount(bank: Bank) {
        val bankQ = banksCol.findOne(Bank::accountNumber eq bank.accountNumber)
        if (bankQ == null) {
            banksCol.insertOne(bank)
        } else {
            ("Error, this account already exists in Database")
        }
    }

    override fun getAccount(accountNumber: Int): Bank? {
        val bankQ = banksCol.findOne(Bank::accountNumber eq accountNumber)
        return bankQ
    }

    override fun getBalance(accountNumber: Int): Int? {
        val bankQ = banksCol.findOne(Bank::accountNumber eq accountNumber)
        return bankQ?.balance
    }

    override fun getStandingOrders(accountNumber: Int) {
        val bankQ = banksCol.findOne(Bank::accountNumber eq accountNumber)
        val ordersQ = bankQ?.standingOrder?.toList()
        if (ordersQ != null) {
            ResponseEntity.ok(ordersQ)
        } else {
            ResponseEntity.badRequest().body(
                "Error! Either the bank was not found, or there is no standing orders"
            )
        }
    }

    override fun createStandingOrder(accountNumber: Int, order: String) {
        banksCol.updateOne(Bank::accountNumber eq accountNumber,
            Bank::standingOrder addToSet order)
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