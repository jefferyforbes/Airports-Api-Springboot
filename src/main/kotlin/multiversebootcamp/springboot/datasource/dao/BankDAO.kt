package multiversebootcamp.springboot.datasource.dao

import multiversebootcamp.springboot.models.Bank
import org.springframework.http.ResponseEntity

interface BankDAO {
    fun createAccount(bank: Bank)
    fun getAccount(accountNumber: Int): Bank?
    fun getBalance(accountNumber: Int): Int?
    fun getStandingOrders(accountNumber: Int)
    fun createStandingOrder(accountNumber: Int, order: String)
    fun sendMoney(senderAccount: Bank, receiptent: Bank, amount: Int)
    fun getAllBanks(): List<Bank>
    fun login(bank: Bank)
}