package multiversebootcamp.springboot.controller

import multiversebootcamp.springboot.datasource.dao.BankDAO
import multiversebootcamp.springboot.models.Bank
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import retrofit2.http.Path
import javax.validation.Valid

@RestController
@RequestMapping("/banks")
class BanksController(private val service: BankDAO) {

    @GetMapping
    fun getAllBanks() = service.getAllBanks()

    @GetMapping("/login")
    fun login(): String = "Account logged into."

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber : Int) = service.getAccount(accountNumber)

    @PostMapping
    fun createBank(@RequestBody bank: Bank) = service.createAccount(bank)

    @GetMapping("/{accountNumber}/balance")
    fun getBalance(@PathVariable accountNumber: Int) = service.getBalance(accountNumber)

    @GetMapping("/{accountNumber}/standing-orders")
    fun getStandingOrders(@PathVariable accountNumber: Int) = service.getStandingOrders(accountNumber)

    @PostMapping("/{accountNumber}/standing-orders")
    @ResponseStatus(HttpStatus.CREATED)
    fun standingOrder(@RequestBody @PathVariable accountNumber: Int, order: String) =
        service.createStandingOrder(accountNumber, order)

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendMoney(@RequestBody sender: Bank, receiver: Bank, amount: Int) = service.sendMoney(sender, receiver, amount)
}