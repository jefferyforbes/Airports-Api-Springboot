package multiversebootcamp.springboot.datasource.dao

import com.mongodb.client.result.UpdateResult
import multiversebootcamp.springboot.models.Bank

interface BankDAO {
    fun createAccount(bank: Bank): String
    fun getAccount(accountNumber: Int): Bank?
    fun getBalance(accountNumber: Int): String?
    fun getStandingOrders(accountNumber: Int): MutableCollection<String?>?
    fun createStandingOrder(accountNumber: Int, order: String)
    fun sendMoney(senderAccount: Int, receiptent: Int, amount: Int)
    fun getAllBanks(): List<Bank>
    fun login(bank: Bank)
}