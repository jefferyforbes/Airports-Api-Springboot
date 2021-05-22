package multiversebootcamp.springboot.controller

import multiversebootcamp.springboot.datasource.dao.BankDAO
import multiversebootcamp.springboot.models.Bank
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpServerErrorException.*
import kotlin.IllegalArgumentException

@RestController
@RequestMapping("/banks")
class BanksController(private val service: BankDAO) {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleNotFound(e:NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleInternalServerError(e: InternalServerError) =
        ResponseEntity(e.message, HttpStatus.INTERNAL_SERVER_ERROR)

    @GetMapping
    fun getAllBanks() = service.getAllBanks()

    @GetMapping("/login")
    fun login(): String = "Account logged into."

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber : Int) = service.getAccount(accountNumber)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBank(@RequestBody bank: Bank) = service.createAccount(bank)

    @GetMapping("/{accountNumber}/balance")
    fun getBalance(@PathVariable accountNumber: Int) = service.getBalance(accountNumber)

    @GetMapping("/{accountNumber}/standing-orders")
    fun getStandingOrders(@PathVariable accountNumber: Int) = service.getStandingOrders(accountNumber)

    @PutMapping("/{accountNumber}/standing-orders")
    @ResponseStatus(HttpStatus.CREATED)
    fun createStandingOrder(@PathVariable accountNumber: Int, @RequestBody order: String) =
        service.createStandingOrder(accountNumber, order)

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendMoney(@RequestBody sender: Bank, receiver: Bank, amount: Int) = service.sendMoney(sender, receiver, amount)
}