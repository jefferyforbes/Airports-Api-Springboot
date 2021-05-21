package multiversebootcamp.springboot.controller

import multiversebootcamp.springboot.datasource.dao.BankDAO
import multiversebootcamp.springboot.models.Bank
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/banks")
class BanksController(private val service: BankDAO) {

    @GetMapping("/login")
    fun login(@RequestBody bank: Bank) = "Account $bank logged into."

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBank(@RequestBody bank: Bank) = service.createAccount(bank)

    @GetMapping("/balance/{bank}")
    fun getBalance(@RequestBody @PathVariable bank: Bank) = service.getBalance(bank)

    @GetMapping("/standing-orders")
    fun getStandingOrders(@RequestBody bank: Bank) = service.getStandingOrders(bank)

    @PostMapping("/standing-orders")
    @ResponseStatus(HttpStatus.CREATED)
    fun standingOrder(@RequestBody bank: Bank, order: String) = service.createStandingOrder(bank, order)

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendMoney(@RequestBody sender: Bank, receiver: Bank, amount: Int) = service.sendMoney(sender, receiver, amount)
}