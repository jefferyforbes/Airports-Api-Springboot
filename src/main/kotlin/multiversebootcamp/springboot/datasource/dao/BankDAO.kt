package multiversebootcamp.springboot.datasource.dao

import multiversebootcamp.springboot.models.Bank
import org.springframework.http.ResponseEntity

interface BankDAO {
    fun createAccount(bank: Bank)
    fun getAccount(bank: Bank)
    fun getBalance(bank: Bank): ResponseEntity<Any>
    fun getStandingOrders(bank: Bank)
    fun createStandingOrder(bank: Bank, order: String)
    fun sendMoney(senderAccount: Bank, receiptent: Bank, amount: Int)
}