package multiversebootcamp.springboot.controller

import multiversebootcamp.springboot.datasource.dao.BankDAO
import multiversebootcamp.springboot.models.Bank
import org.springframework.web.bind.annotation.*

@RestController("/banks")
class BankingController(private val service: BankDAO) {

    @GetMapping("/login")
    fun login(bank: Bank) {

    }

    @PostMapping("/register")
    fun registerBank(@RequestBody bank: Bank) {
        service.createAccount(bank)
    }

    @GetMapping("/balance/{bank}")
    fun getBalance(@PathVariable bank: Bank) {
        service.getBalance(bank)
    }

    @GetMapping("/standing-orders")
    fun getStandingOrders(bank: Bank) {
        service.getStandingOrders(bank)
    }

    fun standingOrder(bank: Bank, order: String) {
        service.createStandingOrder(bank, order)
    }
}