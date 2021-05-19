package multiversebootcamp.springboot.controller

import multiversebootcamp.springboot.datasource.dao.DAO
import multiversebootcamp.springboot.models.User
import multiversebootcamp.springboot.service.AirportService
import multiversebootcamp.springboot.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/user")
class UserController(private val service: AirportService) {

    @GetMapping
    fun allUserNames() = service.

    @GetMapping("/register")
    fun register(): String {
        return "Registered"
    }

    @PostMapping("/login")
    fun login(user:User): String {
        return "On Success logged In"
//        Date(System.currentTimeMillis() + 60 * 1 * 1000) 1 Hour
    }

    @PostMapping("/logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        return ResponseEntity.ok("Logged Out")
    }
}