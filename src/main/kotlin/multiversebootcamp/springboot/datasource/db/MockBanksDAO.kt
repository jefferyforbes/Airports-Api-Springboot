package multiversebootcamp.springboot.datasource.db

import com.mongodb.client.result.UpdateResult
import multiversebootcamp.springboot.datasource.dao.BankDAO
import multiversebootcamp.springboot.datasource.dao.BankDAOImpl
import multiversebootcamp.springboot.models.Bank
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository("mockBankDB")
class MockBanksDAO : BankDAOImpl() {
    val mockBanksDB = mutableListOf<Bank>(
        Bank(
            accountNumber = 234567,
            passcode = 1234,
            balance = 1000,
            standingOrder = mutableListOf()
        )
    )

    override fun createAccount(bank: Bank): String {
        TODO("Not yet implemented")
    }

    override fun getAccount(accountNumber: Int): Bank? {
        TODO("Not yet implemented")
    }

    override fun getBalance(accountNumber: Int): String? {
        TODO("Not yet implemented")
    }

    override fun getStandingOrders(accountNumber: Int): String {
        TODO("Not yet implemented")
    }

    override fun createStandingOrder(accountNumber: Int, order: String) {
        TODO("Not yet implemented")
    }

    override fun sendMoney(senderAccount: Bank, receiptent: Bank, amount: Int) {
        TODO("Not yet implemented")
    }

    override fun login(bank: Bank) {
        TODO("Not yet implemented")
    }
}