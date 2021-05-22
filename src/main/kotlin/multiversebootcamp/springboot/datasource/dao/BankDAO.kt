package multiversebootcamp.springboot.datasource.dao

import com.mongodb.client.result.UpdateResult
import multiversebootcamp.springboot.models.Bank

interface BankDAO {
    fun createAccount(bank: Bank): String
    fun getAccount(accountNumber: Int): Bank?
    fun getBalance(accountNumber: Int): String?
    fun getStandingOrders(accountNumber: Int): String
    fun createStandingOrder(accountNumber: Int, order: String)
    fun sendMoney(senderAccount: Bank, receiptent: Bank, amount: Int)
    fun getAllBanks(): List<Bank>
    fun login(bank: Bank)
}